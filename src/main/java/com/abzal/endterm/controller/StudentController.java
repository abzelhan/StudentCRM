package com.abzal.endterm.controller;

import com.abzal.endterm.model.EducationHistory;
import com.abzal.endterm.model.Faculty;
import com.abzal.endterm.model.Specialty;
import com.abzal.endterm.model.Student;
import com.abzal.endterm.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/user")
public class StudentController {

    @Autowired
    StudentService studentService;

    @Autowired
    SpecialtyService specialtyService;

    @Autowired
    FacultyService facultyService;

    @Autowired
    UserService userService;

    @Autowired
    EducationHistoryService educationHistoryService;

    @RequestMapping(value = "/show-{userId}",method = RequestMethod.GET)
    public String showStudentInfo(@PathVariable int userId, ModelMap map){
        Student student = studentService.findStudentByUserId(userId);
        String username = getCurrentUsername();
        ArrayList<EducationHistory> eduHistories = educationHistoryService.getAll(student);
        map.addAttribute("student",student);
        map.addAttribute("username",username);
        map.addAttribute("edu_histories",eduHistories);
        return "user_profile_page";
    }

    @RequestMapping(value = "/delete-{userId}",method = RequestMethod.GET)
    public String deleteStudentByUserId(@PathVariable int userId){
       userService.deleteUserById(userId);
        return "redirect:/home";
    }

    @RequestMapping(value = "/edit-{userId}",method = RequestMethod.GET)
    public String getStudentInfo(@PathVariable int userId, ModelMap map){
        Student student = studentService.findStudentByUserId(userId);
        System.out.println(student.getSpecialty());
        String username = getCurrentUsername();
        ArrayList<Specialty> allSpecialties = specialtyService.getAllSpecialties();
        ArrayList<Faculty> allFaculties = facultyService.getAllFaculties();
        List<String> educationLevels = Arrays.asList("Associate's degree", "Bachelor's degree", "Master's degree", "Doctoral degree", "Profesional degree");
        List<String> paymentTypes = Arrays.asList("Budget", "Grant", "Rector Grant", "50% discount");
        ArrayList<EducationHistory> eduHistories = educationHistoryService.getAll(student);
        map.addAttribute("student",student);
        map.addAttribute("username",username);
        map.addAttribute("userId",userId);
        map.addAttribute("specialties",allSpecialties);
        map.addAttribute("faculties",allFaculties);
        map.addAttribute("edu_levels",educationLevels);
        map.addAttribute("payment_types",paymentTypes);
        map.addAttribute("edu_histories",eduHistories);

        return "user_editor_page";
    }

    @RequestMapping(value = "/update-basic-{userId}",method = RequestMethod.POST)
    public String editBasicStudentInfo(@PathVariable int userId,
                                 @RequestParam(value = "name") String name,
                                 @RequestParam(value = "surname") String surname,
                                 @RequestParam(value = "birth_date") String date,
                                 @RequestParam(value = "gender") String gender,
                                 @RequestParam(value = "nationality") String nationality,
                                 @RequestParam(value = "address") String address,
                                 @RequestParam(value = "phone_number") String phoneNumber,
                                 @RequestParam(value = "email") String email,
                                 @RequestParam(value = "imageURL") String imageURL
                                 ) throws ParseException {
        Student student = studentService.findStudentByUserId(userId);
        student.setFirstName(name);
        student.setLastName(surname);
        if(date.length()!=0) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date1 = dateFormat.parse(date);
            student.setBirthDate(date1);
        }
        student.setGender(gender);
        student.setNationality(nationality);
        student.setAddress(address);
        student.setPhoneNumber(phoneNumber);
        student.setEmail(email);
        student.setImagePath(imageURL);
        studentService.update(student);
        return "redirect:/user/edit-"+userId;
    }


    @RequestMapping(value = "/update-parents-{userId}",method = RequestMethod.POST)
    public String editParentsStudentInfo(@PathVariable int userId,
                                       @RequestParam(value = "mother_name") String motherName,
                                       @RequestParam(value = "father_name") String fatherName,
                                       @RequestParam(value = "mother_working_place") String motherWorkingPlace,
                                       @RequestParam(value = "father_working_place") String fatherWorkingPlace,
                                       @RequestParam(value = "mother_email") String motherEmail,
                                       @RequestParam(value = "father_email") String fatherEmail
                                       ){
        Student student = studentService.findStudentByUserId(userId);
        student.setMotherName(motherName);
        student.setFatherName(fatherName);
        student.setMotherEmail(motherEmail);
        student.setFatherEmail(fatherEmail);
        student.setMotherWorkingPlace(motherWorkingPlace);
        student.setFatherWorkingPlace(fatherWorkingPlace);
        studentService.update(student);
        return "redirect:/user/edit-"+userId;
    }


    @RequestMapping(value = "/update-documents-{userId}",method = RequestMethod.POST)
    public String editDocStudentInfo(@PathVariable int userId,
                                       @RequestParam(value = "doc_type") String documentType,
                                       @RequestParam(value = "doc_number") String documentNumber,
                                       @RequestParam(value = "doc_organization") String documentOrganization,
                                       @RequestParam(value = "doc_expire") String documentExpireDate
                                       ) throws ParseException {
        Student student = studentService.findStudentByUserId(userId);
        student.setDocType(documentType);
        student.setDocOrganization(documentOrganization);

            student.setDocNumber(documentNumber);

        if(documentExpireDate.length()!=0) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date1 = dateFormat.parse(documentExpireDate);
            student.setDocExpire(date1);
        }
        studentService.update(student);
        return "redirect:/user/edit-"+userId;
    }

    @RequestMapping(value = "/update-education-{userId}",method = RequestMethod.POST)
    public String editEducationInfo(@PathVariable int userId,
                                    @RequestParam(value = "specialty",required = false)String specialtyId,
                                    @RequestParam(value = "entry_year",required = false)String entryYear,
                                    @RequestParam(value = "edu_level",required = false)String edicationLevel,
                                    @RequestParam(value = "payment_type",required = false)String paymentType
                                    ) throws ParseException {
        System.out.println(specialtyId+" "+entryYear+" "+edicationLevel+" "+paymentType);
        Student student = studentService.findStudentByUserId(userId);
        if(specialtyId != null) {
            student.setSpecialty(specialtyService.getById(Integer.parseInt(specialtyId)));
        }
       student.setEduLevel(edicationLevel);
       student.setPaymentType(paymentType);

        if(entryYear.length()!=0) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date1 = dateFormat.parse(entryYear);
            student.setEntryYear(date1);
        }
        studentService.update(student);
        return "redirect:/user/edit-"+userId;
    }

    @RequestMapping(value = "/save-education-history-{userId}",method = RequestMethod.POST)
    public String saveEduHistory(@PathVariable int userId,
                                 @RequestParam("name")String name,
                                 @RequestParam("address")String address,
                                 @RequestParam("during_time_from")String timeFrom,
                                 @RequestParam("during_time_to")String timeTo
                                 ){
        EducationHistory educationHistory = new EducationHistory();
        Student student = studentService.findStudentByUserId(userId);
        educationHistory.setStudent(student);
        educationHistory.setEducatedPlaceName(name);
        educationHistory.setAddress(address);
        educationHistory.setDuringTime(timeFrom+" - "+timeTo);
        System.out.println(educationHistory);
        educationHistoryService.save(educationHistory);
        return "redirect:/user/edit-"+userId;
    }

    @RequestMapping(value = "/remove-education-history-{historyId}-{userId}",method = RequestMethod.GET)
    public String deleteEduHistory(@PathVariable int historyId,@PathVariable int userId){
        educationHistoryService.delete(educationHistoryService.getById(historyId));
        return "redirect:/user/edit-"+userId;
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

}
