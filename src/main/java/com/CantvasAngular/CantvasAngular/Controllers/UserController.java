package com.CantvasAngular.CantvasAngular.Controllers;


import com.CantvasAngular.CantvasAngular.Models.Course;
import com.CantvasAngular.CantvasAngular.Models.SiteUser;
import com.CantvasAngular.CantvasAngular.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    private CourseRepository userRepository;

//    @GetMapping("/users")
//    public List<Course> getUsers() {
//        return (List<Course>) userRepository.findAll();
//    }

//    @PostMapping("/users")
//    void addUser(@RequestBody SiteUser user) {
//        userRepository.save(user);
//    }
}
