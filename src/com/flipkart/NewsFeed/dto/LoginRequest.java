package com.flipkart.NewsFeed.dto;

public class LoginRequest {
    public String getEmail() {
        return Email;
    }

    public String getPassword() {
        return Password;
    }

    public void setEmail(String email) {
        Email = email;
    }

    private String Email;

    public void setPassword(String password) {
        Password = password;
    }

    private String Password;
}
