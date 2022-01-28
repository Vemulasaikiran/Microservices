package com.example.Cart.Service.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CartTable")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cartId;
    @Column
    private int customerId;
    @Column
    private int productId;
    @Column
    private int productSkuId;
    @Column
    private int quantity;


}
