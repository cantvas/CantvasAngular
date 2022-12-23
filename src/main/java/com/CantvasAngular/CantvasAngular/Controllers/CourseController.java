package com.CantvasAngular.CantvasAngular.Controllers;

import com.CantvasAngular.CantvasAngular.Models.Course;
import com.CantvasAngular.CantvasAngular.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseRepository courseRepository;



    @GetMapping("/teachers")
    public List<Course> getTeachers(){
        List<Course> courses = courseRepository.findAll();
        return courses;
    }

//    @GetMapping("/students")
//    public List<Student> getStudents(){return siteUserRepository.getAllStudents();}
}
