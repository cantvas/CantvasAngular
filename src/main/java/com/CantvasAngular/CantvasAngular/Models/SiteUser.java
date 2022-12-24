package com.CantvasAngular.CantvasAngular.Models;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class SiteUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    public String name;
    public String email;

    public SiteUser(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public SiteUser() {}
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
