/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cvonline.cvonline.services;

import com.cvonline.cvonline.entities.WorkAssignment;
import com.cvonline.cvonline.repositories.WorkAssignmentRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author asus
 */
@Service
public class WorkAssignmentService {

    @Autowired
    WorkAssignmentRepository repository;

    public Iterable<WorkAssignment> getAll() {
        return repository.findAll();
    }

    public WorkAssignment getById(String id) {
        return repository.findById(id).get();
    }
    
    public List<WorkAssignment> getByEmployee(String employee) {
        return repository.getByEmployee(employee);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }

    public boolean save(WorkAssignment assignment) {
        if (repository.save(assignment) != null) {
            return true;
        } else {
            return false;
        }
    }

}
