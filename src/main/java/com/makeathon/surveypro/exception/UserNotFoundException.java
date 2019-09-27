package com.makeathon.surveypro.exception;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserNotFoundException extends UsernameNotFoundException {

    private int errorCode;

    public UserNotFoundException(String message, int errorCode) {
        super("User not found with id " + message);
        this.errorCode=errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
}
