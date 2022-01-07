package com.example.Account.Service.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "BillingAddressRepo")
public class BillingAddress {
    @Id
    private String email;
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
