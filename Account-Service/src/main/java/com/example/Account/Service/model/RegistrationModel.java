package com.example.Account.Service.model;
import lombok.Getter;
import lombok.Setter;
import java.util.List;


@Getter
@Setter

public class RegistrationModel
{

    private int id;
    private String name;
    private String email;
    private long mobile_number;
    private String password;

}
