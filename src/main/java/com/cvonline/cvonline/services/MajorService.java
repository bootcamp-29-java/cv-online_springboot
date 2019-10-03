/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cvonline.cvonline.services;

import com.cvonline.cvonline.entities.Major;
import com.cvonline.cvonline.repositories.MajorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author asus
 */
@Service
public class MajorService {

    @Autowired
    MajorRepository repository;

    public Iterable<Major> getAll() {
        return repository.findAll();
    }

    public Major getById(String id) {
        return repository.findById(id).get();
    }

}
