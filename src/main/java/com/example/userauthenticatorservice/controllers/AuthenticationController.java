package com.example.userauthenticatorservice.controllers;

import com.example.userauthenticatorservice.dtos.*;
import com.example.userauthenticatorservice.exceptions.UserAlreadyExistsException;
import com.example.userauthenticatorservice.models.User;
import com.example.userauthenticatorservice.repository.UserRepo;
import com.example.userauthenticatorservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:5173")
public class AuthenticationController {

    @Autowired
    private UserService userService;
    // Sign up
    // Login in
    // forget password
    // logout
    @PostMapping("/signIn")
    public ResponseEntity<ResponseDto<UserResponseDto>> signUp(@RequestBody SignInDto signInDto) {
        try {
            Object response = userService.getUser(signInDto.getEmail());
            if(response != null) {
                throw new UserAlreadyExistsException("This User already exists try using a different email");
            }
            User user = new User();
            user.setEmail(signInDto.getEmail());
            user.setPassword(signInDto.getPassword());
            User createdUser = userService.save(user);
            UserResponseDto userResponseDto = from(createdUser);
            ResponseDto<UserResponseDto> responseDto = new ResponseDto<>(userResponseDto, "User Created", HttpStatus.CREATED);
            return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
        } catch(UserAlreadyExistsException e) {
            ResponseDto<UserResponseDto> errorResponseDto = new ResponseDto<>(null, "User already Exists", HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(errorResponseDto, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            ResponseDto<UserResponseDto> errorResponseDto = new ResponseDto<>(null, "Some Error Occured", HttpStatus.INTERNAL_SERVER_ERROR);
            return new ResponseEntity<>(errorResponseDto, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @RequestMapping("/login")
    public User login(LoginInDto loginInDto) {
        return null;
    }

    @PostMapping("")
    public String postChecking() {
        return "Post call is working";
    }

    @RequestMapping("/forgetPassword")
    public User forgetPassword(ForgetPasswordDto forgetPasswordDto) {
        return null;
    }

    @RequestMapping("/logout")
    public User login(LogoutDto logoutDto) {
        return null;
    }

    private UserResponseDto from(User user) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId(user.getId());
        userResponseDto.setEmail(user.getEmail());
        userResponseDto.setPassword(user.getPassword());
        return userResponseDto;
    }
}
