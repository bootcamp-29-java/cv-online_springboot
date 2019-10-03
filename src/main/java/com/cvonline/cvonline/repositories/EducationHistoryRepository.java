/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cvonline.cvonline.repositories;

import com.cvonline.cvonline.entities.EducationHistory;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author asus
 */
@Repository
public interface EducationHistoryRepository extends CrudRepository<EducationHistory, String>{
    @Query(value = "SELECT * FROM tb_tr_education_history WHERE employee = ?1", nativeQuery = true)
    public List<EducationHistory> getByEmployee(String employee);
}
