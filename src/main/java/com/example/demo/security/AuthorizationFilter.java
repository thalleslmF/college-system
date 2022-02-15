package com.example.demo.security;

import com.example.demo.repository.UserRepository;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;
import io.jsonwebtoken.Jwts;

import javax.crypto.SecretKey;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Enumeration;
import java.util.Locale;

@Component
public class AuthorizationFilter extends GenericFilterBean {

    private final UserRepository userRepository;

    public AuthorizationFilter(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        var httpResponse = (HttpServletResponse) response;
        if(isAuthenticationRequired()) {
            System.out.println(isAuthenticationRequired());
            String authorization = ((HttpServletRequest) request).getHeader("Authorization");
                if(authorization != null) {
                    var jwtToken = authorization.split(" ")[1].trim();
                    SecretKey key = Keys.hmacShaKeyFor(
                            SecurityConstants.JWT_KEY.getBytes(StandardCharsets.UTF_8));
                    var username = (String) Jwts.parserBuilder().setSigningKey(key).
                            build().parseClaimsJws(jwtToken).getBody().get("username");
                    var user = this.userRepository.findByUsername(username);
                    if (user.isEmpty()) {
                        httpResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED);
                    }else {
                        Authentication auth = new UsernamePasswordAuthenticationToken(user.get().getUsername(),user.get().getPassword(),
                                AuthorityUtils.commaSeparatedStringToAuthorityList(username));
                        SecurityContextHolder.getContext().setAuthentication(auth);
                    }
                } else {
                    httpResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED);
                }
        }
        chain.doFilter(request, response);
    }

    private boolean isAuthenticationRequired() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (authentication == null) || !authentication.isAuthenticated();
    }
}
