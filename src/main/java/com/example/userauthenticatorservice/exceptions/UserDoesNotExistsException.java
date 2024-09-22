package com.example.userauthenticatorservice.exceptions;

public class UserDoesNotExistsException extends RuntimeException {
    public UserDoesNotExistsException(String message) {
        super(message);
    }
}
