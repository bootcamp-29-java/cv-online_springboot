/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cvonline.cvonline.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Wehijin
 */
@Controller
public class EmailController {
    
    @Autowired
    private JavaMailSender javaMailSender;
    
    @GetMapping("/sendEmail")
    public String send(String email, RedirectAttributes redirectAttributes) {
        sendEmail(email);
        redirectAttributes.addFlashAttribute("statusEmail", true);
        return "redirect:/cv-employee";
    }
    
    public void sendEmail(String email) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(email);
        msg.setSubject("Please update your CV");
        msg.setText("Silahkan update CV anda yang paling baru");
        javaMailSender.send(msg);
    }
}
