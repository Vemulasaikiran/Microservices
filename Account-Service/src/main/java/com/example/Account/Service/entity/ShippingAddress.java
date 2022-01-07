package com.example.Account.Service.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ShippingAddress")
@Getter
@Setter
public class ShippingAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int billingId;
    @Column
    private int customerId;
    @Column
    private String Line_1;
    @Column
    private String Line_2;
    @Column
    private int postalCode;
    @Column
    private String city;
    @Column
    private String state;
}
