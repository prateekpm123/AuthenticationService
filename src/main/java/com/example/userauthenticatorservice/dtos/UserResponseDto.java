package com.example.userauthenticatorservice.dtos;

import com.example.userauthenticatorservice.models.BaseModel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.util.MultiValueMap;

@Getter
@Setter
public class UserResponseDto extends BaseModel {
    private String email;
    private String password;
}
