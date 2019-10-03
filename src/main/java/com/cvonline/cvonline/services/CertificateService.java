/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cvonline.cvonline.services;

import com.cvonline.cvonline.entities.Certificate;
import com.cvonline.cvonline.repositories.CertificateRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author asus
 */
@Service
public class CertificateService {
    
    @Autowired
    CertificateRepository repository;
    
    public Iterable<Certificate> getAll(){
        return repository.findAll();
    }
    
    public Certificate getById(String id){
        return repository.findById(id).get();
    }
    
    public List<Certificate> getByCategory(String institution){
        return repository.getByCategory(institution);
    }
}
