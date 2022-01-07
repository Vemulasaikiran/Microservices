package com.example.Account.Service.entity;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.hibernate.engine.spi.ManagedEntity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "Registration")

@Getter
@Setter
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    @NotNull(message = "Name Should not be empty")
    private String name;
    @Column
    @Email(message = "Please enter Valid email")
    private String email;
    @Column
    @NotNull(message = "Please Enter phone number")
    private long mobile_number;
    @Column
    @NotNull(message = "Please Enter Strong Password")
    private String password;

}
