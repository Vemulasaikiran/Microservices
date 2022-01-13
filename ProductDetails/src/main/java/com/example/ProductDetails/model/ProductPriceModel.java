package com.example.ProductDetails.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductPriceModel {

    private int priceCode;
    private int skuCode;
    private String currency;
    private int price;
}
