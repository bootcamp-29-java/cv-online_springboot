/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cvonline.cvonline.controllers;

import com.cvonline.cvonline.entities.Employee;
import com.cvonline.cvonline.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author asus
 */
@Controller
public class CvEmployeeController {
    
    @Autowired
    EmployeeService service;
    
    @RequestMapping("/cv-employee")
    public String viewCv(Model model, Employee employee){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) auth.getPrincipal();
        model.addAttribute("employeeId", service.getByEmail(user.getUsername()));
        model.addAttribute("employees", service.getAll());
        return "/cv-employee";
    }
}
