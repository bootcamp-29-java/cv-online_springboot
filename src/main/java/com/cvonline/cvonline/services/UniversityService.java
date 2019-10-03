/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cvonline.cvonline.services;

import com.cvonline.cvonline.entities.University;
import com.cvonline.cvonline.repositories.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author asus
 */
@Service
public class UniversityService {
    
    @Autowired
    UniversityRepository repository;
    
    public Iterable<University> getAll(){
        return repository.findAll();
    }
    
    public University getById(String id){
        return repository.findById(id).get();
    }
    
}
