package com.example.userauthenticatorservice.services;

import com.example.userauthenticatorservice.models.User;
import com.example.userauthenticatorservice.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public User save(User user) {
        return userRepo.save(user);
    }

    public User getUser(String email) {
        User respn = userRepo.findByEmail(email);
        if(respn == null) {
            return null;
        }
        return respn;
    }
}
