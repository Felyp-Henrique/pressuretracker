package com.github.felyphenrique.tracker.application.dtos;

import jakarta.validation.constraints.NotEmpty;

public class AuthenticationRequest {

    @NotEmpty(message = "Email can't be empty!")
    private String email;

    @NotEmpty(message = "Password can't be empty!")
    private String password;

    public AuthenticationRequest() {
        this.email = "";
        this.password = "";
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
