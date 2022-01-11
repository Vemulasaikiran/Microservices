package com.example.ProductDetails.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class ProductSkuModel {
    private int skuCode;
    private int productId;
    private String specifications;
}
