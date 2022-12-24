package com.CantvasAngular.CantvasAngular.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Teacher extends SiteUser{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JsonBackReference
    private Course course;

    public Teacher(){}

    public Teacher(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Teacher(String name, String email, Course course) {
        super(name, email);
        this.course = course;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
