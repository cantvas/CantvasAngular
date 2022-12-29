package com.CantvasAngular.CantvasAngular.Controllers;

import com.CantvasAngular.CantvasAngular.Models.Course;
import com.CantvasAngular.CantvasAngular.Repository.CourseRepository;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CourseController {
    
    @Autowired
    CourseRepository courseRepository;
    
    
    @GetMapping("/courses")
    public List<Course> getCourses() {
        List<Course> courses = courseRepository.findAll();
        return courses;
    }

    @PostMapping("/course")
    public int addCourse(@RequestBody Course course) {
        courseRepository.save(course);
        return Response.SC_OK;
    }

    @GetMapping("/courses/{id}")
    public Course getCourseById(@PathVariable Long id) {
        return courseRepository.findById(id).orElseThrow();
    }
}
