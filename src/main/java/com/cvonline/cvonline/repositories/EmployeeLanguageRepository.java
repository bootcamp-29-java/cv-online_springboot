/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cvonline.cvonline.repositories;
import com.cvonline.cvonline.entities.EmployeeLanguage;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author asus
 */
@Repository
public interface EmployeeLanguageRepository extends CrudRepository<EmployeeLanguage, String> {
    @Query(value = "SELECT * FROM tb_tr_employee_language WHERE employee= ?1", nativeQuery = true)
    public List<EmployeeLanguage> getByEmployee(String employee);
}
