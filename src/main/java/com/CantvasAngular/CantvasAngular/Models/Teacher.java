package com.CantvasAngular.CantvasAngular.Models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Teacher extends SiteUser{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Course course;

    public Teacher(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
