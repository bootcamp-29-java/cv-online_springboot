/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cvonline.cvonline.services;

import com.cvonline.cvonline.entities.Skill;
import com.cvonline.cvonline.repositories.SkillRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author asus
 */
@Service
public class SkillService {
    
    @Autowired
    SkillRepository repository;
    
    public Iterable<Skill> getAll(){
        return repository.findAll();
    }
    
    public Skill getById(String id) {
        return repository.findById(id).get();
    }
    
    public List<Skill> getByCategory(String category) {
        return repository.getByCategory(category);
    }
}
