package com.example.userauthenticatorservice.services;

import com.example.userauthenticatorservice.models.User;
import com.example.userauthenticatorservice.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public User save(User user) {
        return userRepo.save(user);
    }
}
