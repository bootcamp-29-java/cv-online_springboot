/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cvonline.cvonline.services;

import com.cvonline.cvonline.entities.Award;
import com.cvonline.cvonline.repositories.AwardRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author asus
 */
@Service
public class AwardService {
    
    @Autowired
    AwardRepository repository;
    
    public Iterable<Award> getAll(){
        return repository.findAll();
    }
    
    public Award getById(String id){
        return repository.findById(id).get();
    }
    
    public List<Award> getByEmployee(String employee){
        return repository.getByEmployee(employee);
    }
    
    public boolean save(Award award) {
        if (repository.save(award) != null) {
            return true;
        } else {
            return false;
        }
    }
    
    public void delete(String id) {
        repository.deleteById(id);
    }
    
}
