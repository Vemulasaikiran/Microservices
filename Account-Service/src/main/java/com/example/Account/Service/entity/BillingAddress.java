package com.example.Account.Service.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "AddressRepo")
public class BillingAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int billingId;
    @Column
    private Integer customerId;
    @Column
    private String line_1;
    @Column
    private String line_2;
    @Column
    private int postalCode;
    @Column
    private String city;
    @Column
    private String state;
}
