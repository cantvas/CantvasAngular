package com.CantvasAngular.CantvasAngular.Models;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class SiteUser {

    private String name;
    private String email;

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
