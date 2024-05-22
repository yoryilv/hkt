package com.example.hkt.auth.utils;

import com.example.hkt.config.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthorizationUtils {

    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    public JwtAuthenticationFilter authenticationJwtTokenFilter() {
        return jwtAuthenticationFilter;
    }
}
