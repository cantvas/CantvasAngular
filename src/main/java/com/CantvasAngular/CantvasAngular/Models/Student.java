package com.CantvasAngular.CantvasAngular.Models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.util.HashMap;


@Entity
public class Student extends SiteUser{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonBackReference
    @ManyToOne
    private Course course;


    @OneToMany
    @JoinTable(name = "STUDENT_ASSIGNMENTS", joinColumns = @JoinColumn(name = "STUDENT_ID"), inverseJoinColumns = @JoinColumn(name = "ASSIGNMENT_ID"))
    List<Assignment> assignment;
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
