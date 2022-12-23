package com.CantvasAngular.CantvasAngular.Controllers;


import com.CantvasAngular.CantvasAngular.Models.SiteUser;
import com.CantvasAngular.CantvasAngular.Repository.SiteUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    private SiteUserRepository userRepository;

    @GetMapping("/users")
    public List<SiteUser> getUsers() {
        return (List<SiteUser>) userRepository.findAll();
    }

    @PostMapping("/users")
    void addUser(@RequestBody SiteUser user) {
        userRepository.save(user);
    }
}
