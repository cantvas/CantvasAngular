package com.CantvasAngular.CantvasAngular.Controllers;

import com.CantvasAngular.CantvasAngular.Models.Course;
import com.CantvasAngular.CantvasAngular.Repository.CourseRepository;
import jakarta.websocket.server.PathParam;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Optional;

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

    @PostMapping("/coursefake")
    public int addCourseFake() {
        Course course = new Course("ben");
        courseRepository.save(course);
        return Response.SC_OK;
    }
}
