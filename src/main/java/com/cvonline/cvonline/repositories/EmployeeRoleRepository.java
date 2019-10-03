/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cvonline.cvonline.repositories;

import com.cvonline.cvonline.entities.EmployeeRole;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author asus
 */
@Repository
public interface EmployeeRoleRepository extends CrudRepository<EmployeeRole, String> {
    @Query(value = "SELECT r.* FROM tb_tr_employee_role r RIGHT JOIN tb_m_employe e ON e.id = r.employee WHERE e.email = ?1", nativeQuery = true)
    public List<EmployeeRole> getRole(String email);
    
    @Query(value = "SELECT er.* FROM tb_tr_employee_role er RIGHT JOIN tb_m_role r ON r.id = er.role WHERE r.name = ?1", nativeQuery = true)
    public List<EmployeeRole> getIdByRole(String role);
    
    @Query(value = "SELECT * FROM tb_tr_employee_role WHERE employee = ?1", nativeQuery = true)
    public EmployeeRole getRoleByEmployee(String id);
}
