package com.CantvasAngular.CantvasAngular.Controllers;

import com.CantvasAngular.CantvasAngular.Models.Course;
import com.CantvasAngular.CantvasAngular.Models.Student;
import com.CantvasAngular.CantvasAngular.Repository.CourseRepository;
import com.CantvasAngular.CantvasAngular.Repository.StudentRepository;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/api/student")
public class StudentController {

    @Autowired
    StudentRepository siteUserRepository;
    @Autowired
    CourseRepository courseRepository;

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return siteUserRepository.findAll();
    }

    @PostMapping("/student")
    public int createStudent() {
       Course course = courseRepository.getById(1L);
        Student s = new Student("ben", "bhlieberman93@gmail.com", course);
        siteUserRepository.save(s);
        return Response.SC_OK;
    }
}
