package com.makeathon.surveypro.model.request;


import com.makeathon.surveypro.util.ValidationError;

import javax.validation.constraints.Size;

public class LoginRequest {

    @Size(min = 4, max = 50, message = ValidationError.INVALID_USERNAME_LENGTH_KEY)
    private String username;

    @Size(min = 8, max = 50, message = ValidationError.INVALID_PASSWORD_LENGTH_KEY)
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
