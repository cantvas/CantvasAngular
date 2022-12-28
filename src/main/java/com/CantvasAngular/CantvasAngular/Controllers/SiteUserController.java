package com.CantvasAngular.CantvasAngular.Controllers;

import com.CantvasAngular.CantvasAngular.Models.SiteUser;
import com.CantvasAngular.CantvasAngular.Models.Student;
import com.CantvasAngular.CantvasAngular.Repository.SiteUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class SiteUserController {

    @Autowired
    SiteUserRepository siteUserRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    HttpServletRequest request;

    @GetMapping("/users")
    public List<SiteUser> getAllStudents() {
        return siteUserRepository.findAll();
    }

    @PostMapping("/signup")
    public RedirectView postSignup(String username, String password) {
        String hashedPw = passwordEncoder.encode(password);
        SiteUser newUser = new Student(username, hashedPw);
        siteUserRepository.save(newUser);
        return new RedirectView("/course");
    }

//    @PostMapping("/student")
//    public RedirectView createStudent() {
//        Student s = new Student("ben", "bhlieberman93@gmail.com");
//        siteUserRepository.save(s);
//        return new RedirectView("/");
//    }
}
