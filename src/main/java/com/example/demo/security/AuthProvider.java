package com.example.demo.security;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import io.jsonwebtoken.Jwts;

import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;

@Component
public class AuthProvider implements AuthenticationProvider {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthProvider(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        User user;
        String username = authentication.getName();
        System.out.println(username);
        String password = (String) authentication.getCredentials();
        System.out.println(password);
        var optUser = this.userRepository.findByUsername(username);
        if (optUser.isEmpty()) {
            throw new BadCredentialsException("username or password is invalid");
        }
        user = optUser.get();
        var matchPass = this.passwordEncoder.matches(password, user.getPassword());
        if (!matchPass) {
            throw new BadCredentialsException("username or password is invalid");
        }
        return new UsernamePasswordAuthenticationToken(username, password, new ArrayList<>());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return false;
    }

    public String encryptPassword(String password) {
        return this.passwordEncoder.encode(password);
    }

    public String generateToken(String name) {
        SecretKey key = Keys.hmacShaKeyFor(SecurityConstants.JWT_KEY.getBytes(StandardCharsets.UTF_8));
        return Jwts.builder().setIssuer("User app").setSubject("JWT Token")
                .claim("username", name)
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + 300000000))
                .signWith(key).compact();
    }
}
