package com.example.groupapi.service;

import com.example.groupapi.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService {
     UserDetailsService userDetailsService() ;
     List<User> getAllUsers();
}
