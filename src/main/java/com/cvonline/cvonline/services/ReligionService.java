/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cvonline.cvonline.services;

import com.cvonline.cvonline.entities.Religion;
import com.cvonline.cvonline.repositories.ReligionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author asus
 */
@Service
public class ReligionService {

    @Autowired
    ReligionRepository repository;

    public Iterable<Religion> getAll() {
        return repository.findAll();
    }

    public Religion getById(String id) {
        return repository.findById(id).get();
    }
    
    public Religion getByName(String name){
        return repository.getByName(name);
    }

}
