/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cvonline.cvonline.services;

import com.cvonline.cvonline.entities.EmployeeSkill;
import com.cvonline.cvonline.repositories.EmployeeSkillRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author asus
 */
@Service
public class EmployeeSkillService {
    
    @Autowired
    EmployeeSkillRepository repository;
    
    public Iterable<EmployeeSkill> getAll(){
        return repository.findAll();
    }
    
    public EmployeeSkill getById(String id){
        return repository.findById(id).get();
    }
    
    public List<EmployeeSkill> getByEmployee(String employee){
        return repository.getByEmployee(employee);
    }
    
    public boolean save(EmployeeSkill es){
        if (repository.save(es) != null) {
            return true;
        } else {
            return false;
        }
    }
    
    public void delete(String id) {
        repository.deleteById(id);
    }
    
}
