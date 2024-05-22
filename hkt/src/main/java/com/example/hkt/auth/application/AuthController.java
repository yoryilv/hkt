package com.example.hkt.auth.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.hkt.auth.domain.AuthService;
import com.example.hkt.auth.dto.LoginReq;
import com.example.hkt.auth.dto.RegisterReq;
import com.example.hkt.auth.dto.JwtAuthResponse;


@RestController
@RequestMapping("/usuarios")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public String registerUser(@RequestBody RegisterReq registerReq) {
        return authService.register(registerReq);
    }

    @PostMapping("/login")
    public JwtAuthResponse loginUser(@RequestBody LoginReq loginReq) {
        return authService.login(loginReq);
    }
}
