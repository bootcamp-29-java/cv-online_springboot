/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cvonline.cvonline.repositories;

import com.cvonline.cvonline.entities.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


/**
 *
 * @author asus
 */
@Repository
public interface EmployeeRepository extends CrudRepository<Employee, String>{
    
    @Query(value = "SELECT * FROM tb_m_employee where email = ?1", nativeQuery = true)
    public Employee getByEmail(String email);
    
//    @Query(value = "SELECT * FROM tb_m_employee e JOIN tb_tr_employee_role er ON e.id = er.employee WHERE e.email = ?1", nativeQuery = true)
//    public Employee getRole(String role);
   
}
