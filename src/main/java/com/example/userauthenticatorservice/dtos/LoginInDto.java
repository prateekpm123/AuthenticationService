package com.example.userauthenticatorservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginInDto {
    private String email;
    private String password;
}
