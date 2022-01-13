package com.example.ProductDetails.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ProductPrice")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ProductPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int priceCode;
    @Column
    private int skuCode;
    @Column
    private String currency;
    @Column
    private int price;
}
