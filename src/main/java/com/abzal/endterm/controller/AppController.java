package com.abzal.endterm.controller;

import com.abzal.endterm.model.Role;
import com.abzal.endterm.model.RoleEnum;
import com.abzal.endterm.model.User;
import com.abzal.endterm.service.RoleService;
import com.abzal.endterm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.Collection;
import java.util.List;


@Controller
@RequestMapping("/")
//@SessionAttributes("roles")
public class AppController {

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;


    @Autowired
    MessageSource messageSource;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String show(final Principal principal, ModelMap modelMap, SecurityContextHolder securityContextHolder) {
        System.out.println("Basic url /");


        return "redirect:/home";
    }


    @RequestMapping(value = "/home")
    public String redirectToHomePage(ModelMap map){
        System.out.println("/home");
        String currentUserRole = getCurrentUserRole();
        String currentUsername = getCurrentUsername();
        String redirectHomePage = null;
        if(currentUserRole.equals(RoleEnum.ADMIN.getValue())){
            List<User> allUsers = userService.findAllUsers();
            map.addAttribute("users",allUsers);
            map.addAttribute("username", currentUsername);
            redirectHomePage = "admin_panel";

        }
        else if(currentUserRole.equals(RoleEnum.USER.getValue())){
            User user = userService.findByUsername(currentUsername);
            redirectHomePage = "redirect:/user/show-"+user.getId();
        }



        return redirectHomePage;
    }

    @RequestMapping(value = "/registration")
    public String redirectToUserRegisterPage(ModelMap map) {
        List<Role> allRoles = roleService.findAllRoles();
        User user = new User();
        map.addAttribute("roles", allRoles);
        map.addAttribute("user", user);
        return "user_registration_page";
    }



	/**
	 * This method handles Access-Denied redirect.
	 */
	@RequestMapping(value = "/access_denied", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model) {
		model.addAttribute("user", getCurrentUsername());
		return "access_denied";
	}

    private String getCurrentUserRole() {
        String role = null;
        Collection<GrantedAuthority> authorities = getPrincipal().getAuthorities();
        for (GrantedAuthority authority : authorities) {
            role = authority.getAuthority();
        }
        return role;
    }

    private String getCurrentUsername(){
        return getPrincipal().getUsername();
    }

    private org.springframework.security.core.userdetails.User getPrincipal() {
        return (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    /**
     * This method handles login GET requests.
     * If users is already logged-in and tries to goto login page again, will be redirected to list page.
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(final Principal principal) {
        System.out.println("tyt y");
        if (principal == null) {
            return "login";
        } else {
            return "redirect:/home";
        }
    }



    /**
     * This method handles logout requests.
     * Toggle the handlers if you are RememberMe functionality is useless in your app.
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage() {
        System.out.println("Logout");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            //new SecurityContextLogoutHandler().logout(request, response, auth);
            SecurityContextHolder.getContext().setAuthentication(null);
        }
        return "redirect:/login?logout";
    }


}
