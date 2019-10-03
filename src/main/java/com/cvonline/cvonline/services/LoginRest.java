/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cvonline.cvonline.services;

import com.cvonline.cvonline.entities.Login;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author USER
 */
@Service
public class LoginRest {
    private static RestTemplate restTemplate = new RestTemplate();
    
    public Login getById(String param){
        String url = "https://api.myjson.com/bins/{email}";
        Map<String, String> map = new HashMap<String, String>();
        map.put("email", param);
        Login login = restTemplate.getForObject(url, Login.class, map);
        return login;
    }
}
