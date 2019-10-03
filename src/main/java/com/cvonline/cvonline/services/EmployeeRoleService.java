/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cvonline.cvonline.services;

import com.cvonline.cvonline.entities.EmployeeRole;
import com.cvonline.cvonline.repositories.EmployeeRoleRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author asus
 */
@Service
public class EmployeeRoleService {

    @Autowired
    EmployeeRoleRepository repository;

    public Iterable<EmployeeRole> getAll() {
        return repository.findAll();
    }

    public EmployeeRole getById(String id) {
        return repository.findById(id).get();
    }
    
    public EmployeeRole getRole(String id) {
        return repository.getRoleByEmployee(id);
    }
    
//    public List<EmployeeRole> getIdByRole(String role) {
//        return repository.getIdByRole(role);
//    }

    public boolean save(EmployeeRole er) {
        if (repository.save(er) != null) {
            return true;
        } else {
            return false;
        }
    }
    
    public List<EmployeeRole> getSession(String email){
        return repository.getRole(email);
    }
    
    public void delete(String id) {
        repository.deleteById(id);
    }

}
