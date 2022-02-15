package com.example.demo.service;

import com.example.demo.request.UserRequest;
import com.example.demo.entity.User;
import com.example.demo.request.LoginRequest;
import com.example.demo.response.LoginResponse;

public interface UserService {

    public User create(User user);
    public User update(String id);
    public void delete(String id);
    public User findById(String id);

    LoginResponse login(LoginRequest loginRequest);

    User save(UserRequest userRequest);
}
