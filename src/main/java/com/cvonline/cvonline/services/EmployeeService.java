/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cvonline.cvonline.services;

import com.cvonline.cvonline.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cvonline.cvonline.repositories.EmployeeRepository;

/**
 *
 * @author asus
 */
@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository repository;

    public Iterable<Employee> getAll() {
        return repository.findAll();
    }

    public Employee getById(String id) {
        return repository.findById(id).get();
    }
    
    public Employee getByEmail(String email){
        return repository.getByEmail(email);
    }
    
//    public Employee getRole(String role){
//        return repository.getRole(role);
//    }

    public boolean save(Employee employee) {
        if (repository.save(employee) != null) {
            return true;
        } else {
            return false;
        }
    }

    public void delete(String id) {
        repository.deleteById(id);
    }

}
