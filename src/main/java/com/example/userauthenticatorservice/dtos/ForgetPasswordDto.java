package com.example.userauthenticatorservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ForgetPasswordDto {
    private String email;
    private String password;
}
