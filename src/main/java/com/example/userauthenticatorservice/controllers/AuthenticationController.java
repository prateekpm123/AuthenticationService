package com.example.userauthenticatorservice.controllers;

import com.example.userauthenticatorservice.dtos.ForgetPasswordDto;
import com.example.userauthenticatorservice.dtos.LoginInDto;
import com.example.userauthenticatorservice.dtos.LogoutDto;
import com.example.userauthenticatorservice.dtos.SignInDto;
import com.example.userauthenticatorservice.models.User;
import com.example.userauthenticatorservice.repository.UserRepo;
import com.example.userauthenticatorservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private UserService userService;
    // Sign up
    // Login in
    // forget password
    // logout
    @PostMapping("/signIn")
    public ResponseEntity<User> signUp(@RequestBody SignInDto signInDto) {
        User user = new User();
        user.setEmail(signInDto.getEmail());
        user.setPassword(signInDto.getPassword());
        userService.save(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @RequestMapping("/login")
    public User login(LoginInDto loginInDto) {
        return null;
    }

    @RequestMapping("/forgetPassword")
    public User forgetPassword(ForgetPasswordDto forgetPasswordDto) {
        return null;
    }

    @RequestMapping("/logout")
    public User login(LogoutDto logoutDto) {
        return null;
    }
}
