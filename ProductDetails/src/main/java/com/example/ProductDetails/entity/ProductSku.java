package com.example.ProductDetails.entity;


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
@Table(name = "productSku")

public class ProductSku {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productSkuId;

    @Column
    private int productId;
    @Column
    private String specifications;

}
