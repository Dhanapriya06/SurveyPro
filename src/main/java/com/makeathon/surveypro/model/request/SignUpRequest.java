package com.makeathon.surveypro.model.request;


import com.makeathon.surveypro.util.ValidationError;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class SignUpRequest {

    @Size(min = 6, max = 50, message = ValidationError.INVALID_EMAIL_LENGTH_KEY)
    @NotEmpty
    private String email;

    @Size(min = 2, max = 50, message = ValidationError.INVALID_USERNAME_LENGTH_KEY)
    @NotEmpty
    private String username;

    @Size(min = 8, max = 50, message = ValidationError.INVALID_PASSWORD_LENGTH_KEY)
    @NotEmpty
    private String password;

    @Size(min = 4, max = 10, message = ValidationError.INVALID_ROLE_LENGTH_KEY)
    @NotEmpty
    private String role;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
