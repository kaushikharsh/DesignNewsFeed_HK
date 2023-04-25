package com.flipkart.NewsFeed.dto;

import java.util.Date;

public class UserRegisterRequest {
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public long getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Date getDob() {
        return Dob;
    }

    public void setDob(Date dob) {
        Dob = dob;
    }

    private String Name;
    private long PhoneNumber;
    private String Email;
    private String Password; // Can be a Hashed Password
    private Date Dob;  // for future Forget Password
}
