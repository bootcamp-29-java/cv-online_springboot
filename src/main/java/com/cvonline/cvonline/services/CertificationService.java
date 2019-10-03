/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cvonline.cvonline.services;

import com.cvonline.cvonline.entities.Certification;
import com.cvonline.cvonline.repositories.CertificationRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author asus
 */
@Service
public class CertificationService {

    @Autowired
    CertificationRepository repository;

    public Iterable<Certification> getAll() {
        return repository.findAll();
    }
    
    public Certification getById(String id){
        return repository.findById(id).get();
    }
    
    public List<Certification> getByEmployee(String employee) {
        return repository.getByEmployee(employee);
    }
    
    public boolean save(Certification certification){
        if (repository.save(certification) != null) {
            return true;
        } else {
            return false;
        }
    }
    
    public void delete(String id) {
        repository.deleteById(id);
    }

}
