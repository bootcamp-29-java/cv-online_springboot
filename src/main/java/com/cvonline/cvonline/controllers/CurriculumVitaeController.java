/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cvonline.cvonline.controllers;

import com.cvonline.cvonline.entities.Award;
import com.cvonline.cvonline.entities.Certificate;
import com.cvonline.cvonline.entities.Certification;
import com.cvonline.cvonline.entities.Education;
import com.cvonline.cvonline.entities.EducationHistory;
import com.cvonline.cvonline.entities.Employee;
import com.cvonline.cvonline.entities.EmployeeLanguage;
import com.cvonline.cvonline.entities.EmployeeSkill;
import com.cvonline.cvonline.entities.Experience;
import com.cvonline.cvonline.entities.Language;
import com.cvonline.cvonline.entities.Marital;
import com.cvonline.cvonline.entities.Organization;
import com.cvonline.cvonline.entities.Project;
import com.cvonline.cvonline.entities.Religion;
import com.cvonline.cvonline.entities.Skill;
import com.cvonline.cvonline.entities.Training;
import com.cvonline.cvonline.entities.WorkAssignment;
import com.cvonline.cvonline.services.AwardService;
import com.cvonline.cvonline.services.CategoryService;
import com.cvonline.cvonline.services.CertificateService;
import com.cvonline.cvonline.services.CertificationService;
import com.cvonline.cvonline.services.DegreeService;
import com.cvonline.cvonline.services.EducationHistoryService;
import com.cvonline.cvonline.services.EducationService;
import com.cvonline.cvonline.services.EmployeeLanguageService;
import com.cvonline.cvonline.services.EmployeeService;
import com.cvonline.cvonline.services.EmployeeSkillService;
import com.cvonline.cvonline.services.ExperienceService;
import com.cvonline.cvonline.services.InstitutionService;
import com.cvonline.cvonline.services.LanguageService;
import com.cvonline.cvonline.services.MajorService;
import com.cvonline.cvonline.services.MaritalService;
import com.cvonline.cvonline.services.OrganizationService;
import com.cvonline.cvonline.services.ProjectService;
import com.cvonline.cvonline.services.ReligionService;
import com.cvonline.cvonline.services.SkillService;
import com.cvonline.cvonline.services.TrainingService;
import com.cvonline.cvonline.services.UniversityService;
import com.cvonline.cvonline.services.WorkAssignmentService;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Wehijin
 */
@Controller
public class CurriculumVitaeController {

    @RequestMapping("/curriculum-vitae")
    public String session(Model model, Employee employee, EmployeeLanguage employeeLanguage) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) auth.getPrincipal();
        
        // Personal Data
        model.addAttribute("employees", employeeService.getByEmail(user.getUsername()));
        model.addAttribute("religions", religionService.getAll());
        model.addAttribute("maritals", maritalService.getAll());
        // End Personal Data

        // Language
        model.addAttribute("languages", languageService.getAll());
        model.addAttribute("employeeLanguages", employeeLanguageService.getByEmployee(employeeService.getByEmail(user.getUsername()).getId().toString()));
        System.out.println(employeeService.getByEmail(user.getUsername()).getId().toString());
        // End Language

        // Educational Qualification
        model.addAttribute("universities", universityService.getAll());
        model.addAttribute("majors", majorService.getAll());
        model.addAttribute("degrees", degreeService.getAll());
        model.addAttribute("educations", educationService.getAll());
        model.addAttribute("educationHistories", educationHistoryService.getByEmployee(employeeService.getByEmail(user.getUsername()).getId().toString()));
        // End Educational Qualification

        // Technical Qualification
        model.addAttribute("employeeSkills", employeeSkillService.getByEmployee(employeeService.getByEmail(user.getUsername()).getId().toString()));
        model.addAttribute("skills", skillService.getAll());
        model.addAttribute("categories", categoryService.getAll());
        model.addAttribute("skillsPRG", skillService.getByCategory("PL"));
        model.addAttribute("skillsPOS", skillService.getByCategory("OS"));
        model.addAttribute("skillsAPP", skillService.getByCategory("AP"));
        model.addAttribute("skillsDEV", skillService.getByCategory("DP"));
        // End Technical Qualification

        // Work Assignment
        model.addAttribute("works", workAssignmentService.getByEmployee(employeeService.getByEmail(user.getUsername()).getId().toString()));
        // End Work Assignment

        // Project
        model.addAttribute("projects", projectService.getByEmployee(employeeService.getByEmail(user.getUsername()).getId().toString()));
        // End Project

        // Certification
        model.addAttribute("institutions", institutionService.getAll());
        model.addAttribute("certificatesOracle", certificateService.getByCategory("1"));
        model.addAttribute("certificatesMicrosoft", certificateService.getByCategory("2"));
        model.addAttribute("certificatesCisco", certificateService.getByCategory("3"));
        model.addAttribute("certifications", certificationService.getByEmployee(employeeService.getByEmail(user.getUsername()).getId().toString()));
        // End Certification

        // Training
        model.addAttribute("trainings", trainingService.getByEmployee(employeeService.getByEmail(user.getUsername()).getId().toString()));
        // End Training

        // Organization
        model.addAttribute("organizations", organizationService.getByEmployee(employeeService.getByEmail(user.getUsername()).getId().toString()));
        // End Organization

        // Experience
        model.addAttribute("experiences", experienceService.getByEmployee(employeeService.getByEmail(user.getUsername()).getId().toString()));
        // End Experience

        // Award
        model.addAttribute("awards", awardService.getByEmployee(employeeService.getByEmail(user.getUsername()).getId().toString()));
        // End Award
        return "/curriculum-vitae";
    }

//    Personal Data
    @Autowired
    EmployeeService employeeService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    ReligionService religionService;

    @Autowired
    MaritalService maritalService;

    @PostMapping("/save-personaldata")
    public String savePersonalData(@RequestParam("photos") MultipartFile file, Employee employee, Religion religion, Marital marital, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        System.out.println(file);
        System.out.println();
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:/curriculum-vitae#Personal";
        }
        try {
            employee.setPhoto(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(employee.getId());
        System.out.println(employee.getFirstName());
        System.out.println(employee.getLastName());
        System.out.println(employee.getEmail());
        System.out.println(employee.getBirthPlace());
        System.out.println(employee.getBirthDate());
        System.out.println(employee.getGender());
        System.out.println(employee.getNationality());
        System.out.println(employee.getPhoto());
        System.out.println(employee.getReligion());
        System.out.println(employee.getMarital());
        employeeService.save(employee);
        redirectAttributes.addFlashAttribute("statusSave", true);
        return "redirect:/curriculum-vitae#Personal";
    }
//    End Personal Data

//    Language
    @Autowired
    LanguageService languageService;

    @Autowired
    EmployeeLanguageService employeeLanguageService;

    @PostMapping("/save-employeelanguage")
    public String saveEmployeeLanguage(Language language, Employee employee, EmployeeLanguage employeeLanguage, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        employeeLanguage.setId(employeeLanguage.getEmployee().getId() + "/" + employeeLanguage.getLanguage().getId());
        System.out.println(employeeLanguage.getId());
        System.out.println(employeeLanguage.getEmployee());
        System.out.println(employeeLanguage.getLanguage());
        if (bindingResult.hasErrors()) {
            System.out.println("ERROR");
            redirectAttributes.addFlashAttribute("statusSave", false);
            return "redirect:/curriculum-vitae#Language";
        }
        System.out.println("NOT ERROR");
        employeeLanguageService.save(employeeLanguage);
        redirectAttributes.addFlashAttribute("statusSave", true);
        return "redirect:/curriculum-vitae#Language";
    }

    @GetMapping("/delete-employeelanguage")
    public String deleteEmployeeLanguage(String id, RedirectAttributes redirectAttributes) {
        employeeLanguageService.delete(id);
        redirectAttributes.addFlashAttribute("statusDelete", true);
        return "redirect:/curriculum-vitae#Language";
    }
//    End Language

//    Education
    @Autowired
    UniversityService universityService;

    @Autowired
    MajorService majorService;

    @Autowired
    DegreeService degreeService;

    @Autowired
    EducationService educationService;
    
    @Autowired
    EducationHistoryService educationHistoryService;

    @PostMapping("/save-educationhistory")
    public String saveEducationHistory(@RequestParam("certificate") MultipartFile file, Education education, Employee employee, EducationHistory educationHistory, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        educationHistory.setId(educationHistory.getEmployee().getId() + "/" + educationHistory.getEducation().getId());
        
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:/curriculum-vitae#Education";
        }
        try {
            educationHistory.setAttachment(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        System.out.println(educationHistory.getId());
        System.out.println(educationHistory.getGpa());
        System.out.println(educationHistory.getAttachment());
        System.out.println(educationHistory.getEmployee());
        System.out.println(educationHistory.getEducation());
        if (bindingResult.hasErrors()) {
            System.out.println("ERROR");
            redirectAttributes.addFlashAttribute("statusSave", false);
            return "redirect:/curriculum-vitae#Education";
        }
        System.out.println("NOT ERROR");
        educationHistoryService.save(educationHistory);
        redirectAttributes.addFlashAttribute("statusSave", true);
        return "redirect:/curriculum-vitae#Education";
    }

    @GetMapping("/delete-educationhistory")
    public String deleteEducationHistory(String id, RedirectAttributes redirectAttributes) {
        educationHistoryService.delete(id);
        redirectAttributes.addFlashAttribute("statusDelete", true);
        return "redirect:/curriculum-vitae#Education";
    }
//    End Education

//    Technical Qualification
    @Autowired
    SkillService skillService;

    @Autowired
    EmployeeSkillService employeeSkillService;

    @PostMapping("/save-employeeskill")
    public String saveEmployeeSkill(EmployeeSkill employeeSkill, Skill skill, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        employeeSkill.setId(employeeSkill.getEmployee().getId() + "/" + employeeSkill.getSkill().getId());
        System.out.println(employeeSkill.getId());
        System.out.println(employeeSkill.getEmployee().getId());
        System.out.println(employeeSkill.getSkill().getId());
        System.out.println(employeeSkill.getScore());
        if (bindingResult.hasErrors()) {
            System.out.println("ERROR");
            redirectAttributes.addFlashAttribute("statusSave", false);
            return "redirect:/curriculum-vitae#Technical";
        }
        System.out.println("NOT ERROR");
        employeeSkillService.save(employeeSkill);
        redirectAttributes.addFlashAttribute("statusSave", true);
        return "redirect:/curriculum-vitae#Technical";
    }

    @GetMapping("/delete-employeeskill")
    public String deleteEmployeeSkill(String id, RedirectAttributes redirectAttributes) {
        employeeSkillService.delete(id);
        redirectAttributes.addFlashAttribute("statusDelete", true);
        return "redirect:/curriculum-vitae#Technical";
    }
//    End Technical Qualification

//    Work Assignment
    @Autowired
    WorkAssignmentService workAssignmentService;

    @PostMapping("/save-workassignment")
    public String saveWorkAssignment(WorkAssignment workAssignment, Employee employee, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        workAssignment.setId(workAssignment.getEmployee().getId() + "/" + workAssignment.getCompany() + "/" + workAssignment.getPosition());
        System.out.println(employee.getId());
        System.out.println(workAssignment.getId());
        System.out.println(workAssignment.getCompany());
        System.out.println(workAssignment.getPosition());
        System.out.println(workAssignment.getJobDescription());
        System.out.println(workAssignment.getStartDate());
        System.out.println(workAssignment.getEndDate());
        System.out.println(workAssignment.getEmployee());
//        if (bindingResult.hasErrors()) {
//            System.out.println("ERROR");
//            redirectAttributes.addFlashAttribute("statusSave", false);
//            return "redirect:/curriculum-vitae";
//        }
        System.out.println("NOT ERROR");
        workAssignmentService.save(workAssignment);
        redirectAttributes.addFlashAttribute("statusSave", true);
        return "redirect:/curriculum-vitae#Work";
    }

    @GetMapping("/delete-workassignment")
    public String deleteWorkAssignment(String id, RedirectAttributes redirectAttributes) {
        workAssignmentService.delete(id);
        redirectAttributes.addFlashAttribute("statusDelete", true);
        return "redirect:/curriculum-vitae#Work";
    }
//    End Work Assignment

//    Project
    @Autowired
    ProjectService projectService;

    @PostMapping("/save-project")
    public String saveProject(Project project, Employee employee, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        project.setId(project.getEmployee().getId() + "/" + project.getName() + "/" + project.getStartDate());
        System.out.println(project.getId());
        System.out.println(project.getEmployee().getId());
        System.out.println(project.getName());
//        if (bindingResult.hasErrors()) {
//            System.out.println("ERROR");
//            redirectAttributes.addFlashAttribute("statusSave", false);
//            return "redirect:/curriculum-vitae";
//        }
        System.out.println("NOT ERROR");
        projectService.save(project);
        redirectAttributes.addFlashAttribute("statusSave", true);
        return "redirect:/curriculum-vitae#Project";
    }

    @GetMapping("/delete-project")
    public String deleteProject(String id, RedirectAttributes redirectAttributes) {
        projectService.delete(id);
        redirectAttributes.addFlashAttribute("statusDelete", true);
        return "redirect:/curriculum-vitae#Project";
    }
//    End Project

//    Certification
    @Autowired
    InstitutionService institutionService;

    @Autowired
    CertificateService certificateService;

    @Autowired
    CertificationService certificationService;

    @PostMapping("/save-certification")
    public String saveCertification(@RequestParam("certificated") MultipartFile file, Certification certification, Employee employee, Certificate certificate, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        certification.setId(certification.getEmployee().getId() + "/" + certification.getCertificate().getId() + "/" + certification.getCode());
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:/curriculum-vitae#Education";
        }
        try {
            certification.setAttachment(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        System.out.println(certification.getId());
        System.out.println(certification.getEmployee().getId());
        System.out.println(certification.getCertificate().getId());
        System.out.println(certification.getCode());
//        if (bindingResult.hasErrors()) {
//            System.out.println("ERROR");
//            redirectAttributes.addFlashAttribute("statusSave", false);
//            return "redirect:/curriculum-vitae";
//        }
        System.out.println("NOT ERROR");
        certificationService.save(certification);
        redirectAttributes.addFlashAttribute("statusSave", true);
        return "redirect:/curriculum-vitae#Certificate";
    }

    @GetMapping("/delete-certification")
    public String deleteCertification(String id, RedirectAttributes redirectAttributes) {
        certificationService.delete(id);
        redirectAttributes.addFlashAttribute("statusDelete", true);
        return "redirect:/curriculum-vitae#Certificate";
    }
//    End Certification

//    Training
    @Autowired
    TrainingService trainingService;

    @PostMapping("/save-training")
    public String saveTraining(Training training, Employee employee, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        training.setId(training.getEmployee().getId() + "/" + training.getStartDate().getYear() + training.getStartDate().getMonth() + training.getStartDate().getDate() + "/" + training.getEndDate().getYear() + training.getEndDate().getMonth() + training.getEndDate().getDate());
        System.out.println(training.getId());
        System.out.println(training.getEmployee());
        System.out.println(training.getName());
        System.out.println(training.getStartDate());
        System.out.println(training.getEndDate());
//        if (bindingResult.hasErrors()) {
//            System.out.println("ERROR");
//            redirectAttributes.addFlashAttribute("statusSave", false);
//            return "redirect:/curriculum-vitae";
//        }
        System.out.println("NOT ERROR");
        trainingService.save(training);
        redirectAttributes.addFlashAttribute("statusSave", true);
        return "redirect:/curriculum-vitae#Training";
    }

    @GetMapping("/delete-training")
    public String deleteTraining(String id, RedirectAttributes redirectAttributes) {
        trainingService.delete(id);
        redirectAttributes.addFlashAttribute("statusDelete", true);
        return "redirect:/curriculum-vitae#Training";
    }
//    End Training

//    Organization
    @Autowired
    OrganizationService organizationService;

    @PostMapping("/save-organization")
    public String saveOrganization(Organization organization, Employee employee, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        organization.setId(organization.getEmployee().getId() + "/" + organization.getName() + "/" + organization.getPosition());
        System.out.println(organization.getId());
        System.out.println(organization.getEmployee());
        System.out.println(organization.getName());
        System.out.println(organization.getPosition());
        System.out.println(organization.getStartPeriod());
        System.out.println(organization.getEndPeriod());
//        if (bindingResult.hasErrors()) {
//            System.out.println("ERROR");
//            redirectAttributes.addFlashAttribute("statusSave", false);
//            return "redirect:/curriculum-vitae";
//        }
        System.out.println("NOT ERROR");
        organizationService.save(organization);
        redirectAttributes.addFlashAttribute("statusSave", true);
        return "redirect:/curriculum-vitae#Organization";
    }

    @GetMapping("/delete-organization")
    public String deleteOrganization(String id, RedirectAttributes redirectAttributes) {
        organizationService.delete(id);
        redirectAttributes.addFlashAttribute("statusDelete", true);
        return "redirect:/curriculum-vitae#Organization";
    }
//    End Organization

//    Experience
    @Autowired
    ExperienceService experienceService;

    @PostMapping("/save-experience")
    public String saveExperience(Experience experience, Employee employee, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        experience.setId(experience.getEmployee().getId() + "/" + experience.getDate());
        System.out.println(experience.getId());
        System.out.println(experience.getEmployee());
        System.out.println(experience.getName());
        System.out.println(experience.getDate());
//        if (bindingResult.hasErrors()) {
//            System.out.println("ERROR");
//            redirectAttributes.addFlashAttribute("statusSave", false);
//            return "redirect:/curriculum-vitae";
//        }
        System.out.println("NOT ERROR");
        experienceService.save(experience);
        redirectAttributes.addFlashAttribute("statusSave", true);
        return "redirect:/curriculum-vitae#Experience";
    }

    @GetMapping("/delete-experience")
    public String deleteExperience(String id, RedirectAttributes redirectAttributes) {
        experienceService.delete(id);
        redirectAttributes.addFlashAttribute("statusDelete", true);
        return "redirect:/curriculum-vitae#Experience";
    }
//    End Experience

//    Award
    @Autowired
    AwardService awardService;

    @PostMapping("/save-award")
    public String saveAward(Award award, Employee employee, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        award.setId(award.getEmployee().getId() + "/" + award.getDate());
        System.out.println(award.getId());
        System.out.println(award.getEmployee());
        System.out.println(award.getName());
        System.out.println(award.getDate());
//        if (bindingResult.hasErrors()) {
//            System.out.println("ERROR");
//            redirectAttributes.addFlashAttribute("statusSave", false);
//            return "redirect:/curriculum-vitae";
//        }
        System.out.println("NOT ERROR");
        awardService.save(award);
        redirectAttributes.addFlashAttribute("statusSave", true);
        return "redirect:/curriculum-vitae#Award";
    }

    @GetMapping("/delete-award")
    public String deleteAward(String id, RedirectAttributes redirectAttributes) {
        awardService.delete(id);
        redirectAttributes.addFlashAttribute("statusDelete", true);
        return "redirect:/curriculum-vitae#Award";
    }
//    End Award
}
