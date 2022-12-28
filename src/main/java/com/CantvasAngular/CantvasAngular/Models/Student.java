package com.CantvasAngular.CantvasAngular.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;


import java.util.Collection;
import java.util.List;

@Entity
public class Student extends SiteUser{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JsonBackReference
    @ManyToOne
    private Course course;

//    @OneToOne
//    private Gradebook gradebook;

    public Student(){}

    public Student(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Student(String name, String email, Course course) {
        super(name, email);
        this.course = course;
    }

    public long getId() {
        return id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
