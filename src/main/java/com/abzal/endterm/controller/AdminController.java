package com.abzal.endterm.controller;

import com.abzal.endterm.model.Student;
import com.abzal.endterm.model.User;
import com.abzal.endterm.service.StudentService;
import com.abzal.endterm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("/control")
public class AdminController {

    @Autowired
    UserService userService;

    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/registrate",method = RequestMethod.POST)
    public String registrateNewUser(@Valid @ModelAttribute("user") User user, BindingResult result, ModelMap model){

        String userRole = user.getRole().getName();

        userService.saveUser(user);
        if(userRole.equals("USER")){
            Student student = new Student();
            student.setIdUser(user.getId());
            studentService.save(student);
        }

            return "redirect:/";
    }





}
