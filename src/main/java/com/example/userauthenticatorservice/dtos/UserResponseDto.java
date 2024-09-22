package com.example.userauthenticatorservice.dtos;

import com.example.userauthenticatorservice.models.BaseModel;
import com.example.userauthenticatorservice.models.UserStatus;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.util.MultiValueMap;

@Getter
@Setter
public class UserResponseDto {
    private long id;
    private String email;
    private String password;
    private UserStatus userStatus;
}
