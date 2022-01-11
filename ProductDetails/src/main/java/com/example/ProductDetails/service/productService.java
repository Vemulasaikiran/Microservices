package com.example.ProductDetails.service;


import com.example.ProductDetails.entity.ProductDetails;
import com.example.ProductDetails.model.ProductDetailsModel;
import com.example.ProductDetails.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class productService
    {
        @Autowired
        private ProductRepo productRepo;

        public ProductDetails add(ProductDetailsModel productModel)
        {
            ProductDetails details = new ProductDetails();
            details.setName(productModel.getName());
            details.setDescription(productModel.getDescription());
            return productRepo.save(details);
        }



    }
