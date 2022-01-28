package com.example.Cart.Service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartInput {

    private int customerId;
    private int productId;
    private int productSkuId;
    private int quantity;


}
