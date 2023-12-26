package com.example.groupapi.service;

import com.example.groupapi.Dao.JwtAuthenticationResponse;
import com.example.groupapi.Dao.SignUpRequest;
import com.example.groupapi.Dao.SigninRequest;
import com.example.groupapi.entity.User;

public interface AuthenticationService {
    User signup(SignUpRequest signUpRequest);
    JwtAuthenticationResponse signin(SigninRequest signinRequest);
}
