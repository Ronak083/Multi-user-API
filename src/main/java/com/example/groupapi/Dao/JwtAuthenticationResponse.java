package com.example.groupapi.Dao;

import lombok.Data;

@Data
public class JwtAuthenticationResponse {
    private String username;
    private String token;

}
