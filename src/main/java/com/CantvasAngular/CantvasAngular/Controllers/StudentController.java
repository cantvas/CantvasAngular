package com.CantvasAngular.CantvasAngular.Controllers;

import com.CantvasAngular.CantvasAngular.Models.SiteUser;
import com.CantvasAngular.CantvasAngular.Models.Student;
import com.CantvasAngular.CantvasAngular.Repository.SiteUserRepository;
import com.CantvasAngular.CantvasAngular.Repository.StudentRepository;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentRepository siteUserRepository;

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return siteUserRepository.findAll();
    }

    @PostMapping("/student")
    public int createStudent() {
        Student s = new Student("ben", "bhlieberman93@gmail.com");
        siteUserRepository.save(s);
        return Response.SC_OK;
    }
}
