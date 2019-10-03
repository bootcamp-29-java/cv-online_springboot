/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cvonline.cvonline.services;

import com.cvonline.cvonline.entities.Organization;
import com.cvonline.cvonline.repositories.OrganizationRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author asus
 */
@Service
public class OrganizationService {

    @Autowired
    OrganizationRepository repository;

    public Iterable<Organization> getAll() {
        return repository.findAll();
    }

    public Organization getById(String id) {
        return repository.findById(id).get();
    }
    
    public List<Organization> getByEmployee(String employee) {
        return repository.getByEmployee(employee);
    }

    public boolean save(Organization organization) {
        if (repository.save(organization) != null) {
            return true;
        } else {
            return false;
        }
    }
    
    public void delete(String id) {
        repository.deleteById(id);
    }

}
