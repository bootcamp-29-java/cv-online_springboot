/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cvonline.cvonline.repositories;

import com.cvonline.cvonline.entities.Degree;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author asus
 */
@Repository
public interface DegreeRepository extends CrudRepository<Degree, String>{
    
}
