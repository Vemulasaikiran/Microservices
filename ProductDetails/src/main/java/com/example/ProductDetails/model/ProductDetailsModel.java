package com.example.ProductDetails.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductDetailsModel {
    private int productId;
    private String name;
    private String description;

}
