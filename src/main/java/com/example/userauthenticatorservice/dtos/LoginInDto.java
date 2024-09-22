package com.example.userauthenticatorservice.dtos;

import com.example.userauthenticatorservice.models.UserStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
// this is the data that comes from the UI
public class LoginInDto {
    private String email;
    private String password;
}
