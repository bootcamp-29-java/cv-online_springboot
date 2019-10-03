/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cvonline.cvonline.services;

import com.cvonline.cvonline.entities.Project;
import com.cvonline.cvonline.repositories.ProjectRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author asus
 */
@Service
public class ProjectService {
    
    @Autowired
    ProjectRepository repository;
    
    public Iterable<Project> getAll(){
        return repository.findAll();
    }
    
    public Project getById(String id){
        return repository.findById(id).get();
    }
    
    public List<Project> getByEmployee(String employee) {
        return repository.getByEmployee(employee);
    }
    
    public boolean save(Project project) {
        if (repository.save(project) != null) {
            return true;
        } else {
            return false;
        }
    }
    
    public void delete(String id) {
        repository.deleteById(id);
    }
    
}
