package com.example.Account.Service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class LoginModel {
    @Email(message = "Enter Valid Email")
    private String email;
    private String password;

}
