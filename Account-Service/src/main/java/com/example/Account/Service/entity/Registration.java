package com.example.Account.Service.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Registration")

@Getter
@Setter
public class Registration {
    @Id
    private int id;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private long mobile_number;
    @Column
    private String password;

//    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
//    @JoinColumn(name = "Shipping_Address",referencedColumnName = "id")
//
//    private List<ShippingAddress> shippingAddress;
//    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
//    @JoinColumn(name = "Shipping_Address",referencedColumnName = "id")
//
//    private List<BillingAddress> billingAddress;
}
