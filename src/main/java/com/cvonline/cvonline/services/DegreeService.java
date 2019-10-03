/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cvonline.cvonline.services;

import com.cvonline.cvonline.entities.Degree;
import com.cvonline.cvonline.repositories.DegreeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author asus
 */
@Service
public class DegreeService {
    
    @Autowired
    DegreeRepository repository;
    
    public Iterable<Degree> getAll() {
        return repository.findAll();
    }
    
    public Degree getById(String id){
        return repository.findById(id).get();
    }
    
}
