package com.example.groupapi.Dao;

import lombok.Data;

@Data
public class JwtAuthenticationResponse {
    private String token;
    private String refreshYoken;
}
