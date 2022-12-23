package com.CantvasAngular.CantvasAngular.Models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Teacher extends SiteUser{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToMany(mappedBy = "Course")
    @JoinTable(
            joinColumns = {@JoinColumn(name = "Course.id")},
            inverseJoinColumns = {@JoinColumn(name = "Teacher.id")})
    private List<Course> courseList;

    public Teacher(){}
}
