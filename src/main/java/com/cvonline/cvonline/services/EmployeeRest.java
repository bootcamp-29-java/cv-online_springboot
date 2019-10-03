/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cvonline.cvonline.services;

import com.cvonline.cvonline.entities.EmployeeDummy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author USER
 */
@Service
@Transactional
public class EmployeeRest {

//    private static RestTemplate restTemplate = new RestTemplate();
//
//    public EmployeeDummy login(String email, String password) {
//        String url = "http://192.168.137.242:8084/login/?email={email}&password={password}";
//        Map<String, String> map = new HashMap<String, String>();
//        map.put("email", email);
//        map.put("password", password);
//
//        EmployeeDummy employeeDummy = restTemplate.getForObject(url, EmployeeDummy.class, map);
//        return employeeDummy;
//    }
//
//    public List<EmployeeDummy> getEmployeeDummys(String id) {
//        String url = "http://192.168.137.242:8084/employee/{id}";
//        Map<String, String> map = new HashMap<String, String>();
//        map.put("id", id);
//
//        ResponseEntity<List<EmployeeDummy>> re = restTemplate.exchange(url, HttpMethod.GET, null,
//                new ParameterizedTypeReference<List<EmployeeDummy>>() {
//        }, map);
//        List<EmployeeDummy> employeeDummys = re.getBody();
//        return employeeDummys;
//    }

//    public EmployeeDummy getById(String id)
}
