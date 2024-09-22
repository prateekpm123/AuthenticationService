package com.example.userauthenticatorservice.controllers;

import com.example.userauthenticatorservice.dtos.*;
import com.example.userauthenticatorservice.exceptions.UserAlreadyExistsException;
import com.example.userauthenticatorservice.exceptions.UserDoesNotExistsException;
import com.example.userauthenticatorservice.models.User;
import com.example.userauthenticatorservice.models.UserStatus;
import com.example.userauthenticatorservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        User user = new User();
        user.setEmail(signInDto.getEmail());
        user.setPassword(signInDto.getPassword());
        user.setUserStatus(UserStatus.LOGGED_IN);
        try {
            Object response = userService.getUser(signInDto.getEmail());
            if(response != null) {
                throw new UserAlreadyExistsException("This User already exists try using a different email");
            }
            User createdUser = userService.save(user);
            UserResponseDto userResponseDto = from(createdUser);
            ResponseDto<UserResponseDto> responseDto = new ResponseDto<>(userResponseDto, "User Created", HttpStatus.CREATED);
            return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
        } catch(UserAlreadyExistsException e) {
            ResponseDto<UserResponseDto> errorResponseDto = new ResponseDto<>(null, "User already Exists", HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(errorResponseDto, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            ResponseDto<UserResponseDto> errorResponseDto = new ResponseDto<>(null, "Some Error Occured", HttpStatus.INTERNAL_SERVER_ERROR);
            userService.updateUserStatus(user.getUserStatus(), user.getId());
            return new ResponseEntity<>(errorResponseDto, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    // An API endpoint to Health check
    @RequestMapping("/status")
    public Boolean sendHealthCheckup() {
        return true;
    }

    @RequestMapping("/login")
    public ResponseEntity<ResponseDto<UserResponseDto>> login(@RequestBody LoginInDto loginInDto) {
        try {
            User user = userService.getUser(loginInDto.getEmail());
            if(user == null) {
                throw new UserDoesNotExistsException("This User does not exist try using a different email");
            }
            user.setUserStatus(UserStatus.LOGGED_IN);
            User userUpdated = userService.save(user);
            // Making a response to send to the UI
            UserResponseDto userResponseDto = from(userUpdated);
            ResponseDto responseDto = new ResponseDto<>(userResponseDto, "Login Successful", HttpStatus.OK);
            return new ResponseEntity<>(responseDto, HttpStatus.OK);
        } catch(UserDoesNotExistsException e) {
            System.out.println(e.getMessage());
            ResponseDto responseDto = new ResponseDto(null, e.getMessage(), HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(responseDto,HttpStatus.BAD_REQUEST);
        } catch(Exception e) {
            System.out.println(e.getMessage());
            ResponseDto responseDto = new ResponseDto(null, "Some error occured" + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            return new ResponseEntity<>(responseDto,HttpStatus.INTERNAL_SERVER_ERROR);
        }
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
