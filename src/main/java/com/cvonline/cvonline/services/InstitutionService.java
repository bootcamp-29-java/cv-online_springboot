/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cvonline.cvonline.services;

import com.cvonline.cvonline.entities.Institution;
import com.cvonline.cvonline.repositories.InstitutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author asus
 */
@Service
public class InstitutionService {
    
    @Autowired
    InstitutionRepository repository;
    
    public Iterable<Institution> getAll(){
        return repository.findAll();
    }
    
    public Institution getById(String id){
        return repository.findById(id).get();
    }
    
}
