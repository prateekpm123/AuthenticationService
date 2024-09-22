package com.example.userauthenticatorservice.dtos;


import com.example.userauthenticatorservice.models.UserStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignInDto {
    private String email;
    private String password;
    private UserStatus userStatus;
}
