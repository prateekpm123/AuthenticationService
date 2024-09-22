package com.example.userauthenticatorservice.dtos;

import com.example.userauthenticatorservice.models.UserStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LogoutDto {
    private String email;
    private UserStatus userStatus;

}
