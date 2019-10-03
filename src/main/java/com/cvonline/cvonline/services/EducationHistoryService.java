/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cvonline.cvonline.services;

import com.cvonline.cvonline.entities.EducationHistory;
import com.cvonline.cvonline.repositories.EducationHistoryRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author asus
 */
@Service
public class EducationHistoryService {
    
    @Autowired
    EducationHistoryRepository repository;
    
    public Iterable<EducationHistory> getAll(){
        return repository.findAll();
    }
    
    public EducationHistory getById(String id){
        return repository.findById(id).get();
    }
    
    public List<EducationHistory> getByEmployee(String employee) {
        return repository.getByEmployee(employee);
    }
    
    public boolean save(EducationHistory eh){
        if (repository.save(eh) != null) {
            return true;
        } else {
            return false;
        }
    }
    
    public void delete(String id) {
        repository.deleteById(id);
    }
}
