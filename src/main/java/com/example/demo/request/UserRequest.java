package com.example.demo.request;

import com.example.demo.entity.User;

public class UserRequest {
    private String username;
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

    public User toEntity(String password) {
        return new User(password, this.username);
    }
}
