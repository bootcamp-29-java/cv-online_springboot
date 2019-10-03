/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cvonline.cvonline.services;

import com.cvonline.cvonline.entities.Training;
import com.cvonline.cvonline.repositories.TrainingRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author asus
 */
@Service
public class TrainingService {
    
    @Autowired
    TrainingRepository repository;
    
    public Iterable<Training> getAll() {
        return repository.findAll();
    }
    
    public Training getById(String id) {
        return repository.findById(id).get();
    }
    
    public List<Training> getByEmployee(String employee) {
        return repository.getByEmployee(employee);
    }
    
    public boolean save(Training training){
        if (repository.save(training) != null) {
            return true;
        } else {
            return false;
        }
    }
    
    public void delete(String id) {
        repository.deleteById(id);
    }
    
}
