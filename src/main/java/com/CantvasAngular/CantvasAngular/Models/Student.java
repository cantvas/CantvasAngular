package com.CantvasAngular.CantvasAngular.Models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Student extends SiteUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToMany
    @JoinTable(
            joinColumns = {@JoinColumn(name = "Course.id")},
            inverseJoinColumns = {@JoinColumn(name = "Student.id")})
    private List<Course> courseList;

    public Student() {
    }

}
