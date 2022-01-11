package com.example.ProductDetails.controller;

import com.example.ProductDetails.entity.ProductSku;
import com.example.ProductDetails.model.ProductDetailsModel;
import com.example.ProductDetails.model.ProductSkuModel;
import com.example.ProductDetails.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    public ProductService productService;

    @PostMapping("/add-products")
    private void addProduct(@RequestBody ProductDetailsModel productDetails)
    {
        productService.addProduct(productDetails);
    }

    @GetMapping("/get-products")
    private List<ProductDetailsModel> productDetails()
    {
        return productService.getProd();
    }
    @PostMapping("/add-product-sku/{productId}")
    private ProductSku addSku(@RequestBody ProductSkuModel productSkuModel, @PathVariable int productId)
    {
        return productService.addSku(productSkuModel,productId);
    }

}
