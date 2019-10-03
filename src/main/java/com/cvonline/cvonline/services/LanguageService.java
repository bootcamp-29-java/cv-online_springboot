/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cvonline.cvonline.services;

import com.cvonline.cvonline.entities.Language;
import com.cvonline.cvonline.repositories.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author asus
 */
@Service
public class LanguageService {
    
    @Autowired
    LanguageRepository repository;
    
    public Iterable<Language> getAll(){
        return repository.findAll();
    }
    
    public Language getById(String id){
        return repository.findById(id).get();
    }
    
}
