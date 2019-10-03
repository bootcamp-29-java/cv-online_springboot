/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cvonline.cvonline.controllers;

import com.cvonline.cvonline.services.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author USER
 */
@Controller
public class ReportController {
    
    @Autowired
    private ReportService reportService;
    
    @RequestMapping("/save-cv")
    private String loadCv(String id){
        reportService.generateReport(id);
        return "/redirect-cv";
    }
}
