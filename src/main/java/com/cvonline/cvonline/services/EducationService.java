/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cvonline.cvonline.services;

import com.cvonline.cvonline.entities.Education;
import com.cvonline.cvonline.repositories.EducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author asus
 */
@Service
public class EducationService {
    
    @Autowired
    EducationRepository repository;
    
    public Iterable<Education> getAll() {
        return repository.findAll();
    }
    
    public Education getById(String id) {
        return repository.findById(id).get();
    }
     
}
