package com.example.ProductDetails.controller;

import com.example.ProductDetails.model.ProductDetailsModel;
import com.example.ProductDetails.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    public ProductService productService;

    @PostMapping("/add-products")
    private void addProduct(@RequestBody ProductDetailsModel productDetails)
    {
        productService.addProduct(productDetails);
    }


}
