package com.example.demo.entity;

import com.example.demo.response.UserResponse;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
@Getter
@Setter
public class User {
    @GeneratedValue()
    @Id
    private long id;
    private String username;

    private String password;

    private boolean active;

    public User() {
    }

    public User(String password, String username) {
        this.password = password;
        this.username = username;
    }


    public UserResponse toResponse() {
        return new UserResponse(this.id);
    }
}
