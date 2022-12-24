package com.CantvasAngular.CantvasAngular.Models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Student extends SiteUser{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Course course;

    public Student(){}

    public Student(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
