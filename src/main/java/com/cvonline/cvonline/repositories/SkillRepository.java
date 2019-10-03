/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cvonline.cvonline.repositories;

import com.cvonline.cvonline.entities.Skill;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author asus
 */
@Repository
public interface SkillRepository extends CrudRepository<Skill, String> {
    @Query(value = "SELECT * FROM tb_m_skill WHERE category = ?1", nativeQuery = true)
    public List<Skill> getByCategory(String id);
}
