package com.example.demo.service.impl;

import com.example.demo.request.UserRequest;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.request.LoginRequest;
import com.example.demo.response.LoginResponse;
import com.example.demo.security.AuthProvider;
import com.example.demo.service.UserService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final AuthProvider authProvider;

    public UserServiceImpl(UserRepository userRepository, AuthProvider authProvider) {
        this.userRepository = userRepository;
        this.authProvider = authProvider;
    }
    @Override
    public User create(User user) {
        return null;
    }

    @Override
    public User update(String id) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public User findById(String id) {
        return null;
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                loginRequest.getUsername(),
                loginRequest.getPassword()
        );
        this.authProvider.authenticate(authentication);
        var token =  this.authProvider.generateToken(authentication.getName());
        return new LoginResponse(token);
    }

    @Override
    public User save(UserRequest userRequest) {
        var encryptedPass = this.authProvider.encryptPassword(userRequest.getPassword());
        return this.userRepository.save(userRequest.toEntity(encryptedPass));
    }
}
