package com.example.userauthenticatorservice.models;


import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
public class User extends BaseModel{
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;
    @ManyToMany
    private Set<Role> roles = new HashSet<>();
}
