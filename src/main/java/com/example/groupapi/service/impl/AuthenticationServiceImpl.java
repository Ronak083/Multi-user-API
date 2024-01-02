package com.example.groupapi.service.impl;

import com.example.groupapi.Dao.JwtAuthenticationResponse;
import com.example.groupapi.Dao.SignUpRequest;
import com.example.groupapi.Dao.SigninRequest;
import com.example.groupapi.entity.Role;
import com.example.groupapi.entity.User;
import com.example.groupapi.repository.UserRepository;
import com.example.groupapi.service.AuthenticationService;
import com.example.groupapi.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@RequiredArgsConstructor
@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public User signup(SignUpRequest signUpRequest){
        User user = new User();
        user.setEmail(signUpRequest.getEmail());
        user.setFirstName(signUpRequest.getFirstName());
        user.setLastName(signUpRequest.getLastName());
        user.setRole(Role.USER);
        user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));

        return userRepository.save(user);

    }

    public JwtAuthenticationResponse signin(SigninRequest signinRequest) throws IllegalArgumentException{
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signinRequest.getEmail(), signinRequest.getPassword()));
        var user = userRepository.findByEmail(signinRequest.getEmail());

        var jwt = jwtService.generateToken(user);


        JwtAuthenticationResponse jwtAuthenticationResponse = new JwtAuthenticationResponse();
        jwtAuthenticationResponse.setUsername(user.getUsername());
        jwtAuthenticationResponse.setToken(jwt);
        return jwtAuthenticationResponse;
    }
}

