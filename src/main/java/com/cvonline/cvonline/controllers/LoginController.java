/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cvonline.cvonline.controllers;

import com.cvonline.cvonline.entities.Employee;
import com.cvonline.cvonline.entities.EmployeeDummy;
import com.cvonline.cvonline.entities.EmployeeRole;
import com.cvonline.cvonline.services.EmployeeRest;
import com.cvonline.cvonline.services.EmployeeRoleService;
import com.cvonline.cvonline.services.EmployeeService;
import com.cvonline.cvonline.services.LoginRest;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author USER
 */
@Controller
public class LoginController {

    @Autowired
    private EmployeeRest employeeRest;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private LoginRest loginRest;
    
    @Autowired
    private EmployeeRoleService employeeRoleService;

//    @PostMapping("/verifikasi")
//    public String testing(@ModelAttribute(value = "email") String email, @ModelAttribute(value = "password") String password) {
//        String result = "";
//        EmployeeDummy employee = employeeRest.login(email, password);
//        if (employee.getStatus().equalsIgnoreCase("Berhasil")) {
//            Employee empl = employeeService.getById(employee.getId());
//            empl.setEmail(employee.getEmail());
//            empl.setFirstName(employee.getFirstName());
//            empl.setLastName(employee.getLastName());
//            empl.setLastName(employee.getLastName());
//            employeeService.save(empl);
//            User user = new User(employee.getId(), "", getAuthorities(employee));
//            PreAuthenticatedAuthenticationToken authentication = new PreAuthenticatedAuthenticationToken(user, "", user.getAuthorities());
//            SecurityContextHolder.getContext().setAuthentication(authentication);
//            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//            result = "redirect:/";
//        } else {
//            result = "redirect:/loginerror";
//        }
//        return result;
//    }

    private static Collection<? extends GrantedAuthority> getAuthorities(EmployeeDummy user) {
        String[] roles = user.getRoles();
        final List<SimpleGrantedAuthority> authorities = new LinkedList<>();
        for (String role : user.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
    }
    
    public List<EmployeeRole> getSession() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName();
        return employeeRoleService.getSession(email);
    }

    @RequestMapping("/")
    public String home(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) auth.getPrincipal();
        if (auth.getAuthorities() != null) {
            model.addAttribute("employeeId", employeeService.getByEmail(user.getUsername()));
            model.addAttribute("employeeRole", employeeRoleService.getRole(employeeService.getByEmail(user.getUsername()).getId().toString()));
//            return "/managerpage/home";
            return "/home";
        }
//        } else if(auth.getAuthorities().toString().contains("STAFF")) {
//            model.addAttribute("employeeId", employeeService.getByEmail(user.getUsername()));
////            return "/staffpage/home";
//            return "/home";
//        }
        return "login";
    }

    @RequestMapping("/loginerror")
    public String loginerror(RedirectAttributes redirect) {
        System.out.println("Gagal Login");
        redirect.addFlashAttribute("statusLogin", false);
        return "redirect:/login";
    }

    @RequestMapping("/logoutsuccess")
    public String logoutsuccess(RedirectAttributes redirect) {
        redirect.addFlashAttribute("message", "Logout Success");
        return "redirect:/";
    }

    @GetMapping("/login")
    public String handlingLog() {
        String result = "";
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!auth.getName().equalsIgnoreCase("anonymousUser")) {
            result = "redirect:/";
        } else {
            result = "login";
        }
        return result;
    }
}
