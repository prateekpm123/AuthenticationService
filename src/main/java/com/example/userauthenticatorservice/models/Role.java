package com.example.userauthenticatorservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;

import java.util.Set;

@Entity
public class Role extends BaseModel {
    private String role;

//    @ManyToMany
//    private Set<User> user;
}
