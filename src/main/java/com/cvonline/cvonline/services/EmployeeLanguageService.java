/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cvonline.cvonline.services;

import com.cvonline.cvonline.entities.Employee;
import com.cvonline.cvonline.entities.EmployeeLanguage;
import com.cvonline.cvonline.repositories.EmployeeLanguageRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author asus
 */
@Service
public class EmployeeLanguageService {

    @Autowired
    EmployeeLanguageRepository repository;

    public Iterable<EmployeeLanguage> getAll() {
        return repository.findAll();
    }

    public EmployeeLanguage getById(String id) {
        return repository.findById(id).get();
    }
    
    public List<EmployeeLanguage> getByEmployee(String employee){
        return  repository.getByEmployee(employee);
    }

    public boolean save(EmployeeLanguage el) {
        if (repository.save(el) != null) {
            return true;
        } else {
            return false;
        }
    }

    public void delete(String id) {
        repository.deleteById(id);
    }

}
