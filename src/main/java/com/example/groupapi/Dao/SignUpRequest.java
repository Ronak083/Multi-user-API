package com.example.groupapi.Dao;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class SignUpRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
