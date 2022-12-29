package com.CantvasAngular.CantvasAngular.Controllers;

import com.CantvasAngular.CantvasAngular.Models.SiteUser;
import com.CantvasAngular.CantvasAngular.Repository.SiteUserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class SiteUserController {

    @Autowired
    SiteUserRepository siteUserRepository;


    @GetMapping("/users")
    public List<SiteUser> getAllStudents() {
        return siteUserRepository.findAll();
    }


//    @PostMapping("/student")
//    public RedirectView createStudent() {
//        Student s = new Student("ben", "bhlieberman93@gmail.com");
//        siteUserRepository.save(s);
//        return new RedirectView("/");
//    }
}
