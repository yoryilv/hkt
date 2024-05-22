package com.example.hkt.auth.dto;

import lombok.Data;

@Data
public class JwtAuthResponse {
    private String token;

    public JwtAuthResponse(String token) {this.token = token;}

    public String getToken() {return token;}
}