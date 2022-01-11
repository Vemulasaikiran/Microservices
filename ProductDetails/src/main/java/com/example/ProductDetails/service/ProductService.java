package com.example.ProductDetails.service;


import com.example.ProductDetails.entity.ProductDetails;
import com.example.ProductDetails.entity.ProductSku;
import com.example.ProductDetails.model.ProductDetailsModel;
import com.example.ProductDetails.model.ProductSkuModel;
import com.example.ProductDetails.repository.ProductRepo;
import com.example.ProductDetails.repository.ProductSkuRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService
    {
        @Autowired
        private ProductRepo productRepo;
        @Autowired
        private ProductSkuRepo productSkuRepo;

        public ProductDetails addProduct(ProductDetailsModel productModel)
        {
            ProductDetails details = new ProductDetails();
            details.setName(productModel.getName());
            details.setDescription(productModel.getDescription());
            return productRepo.save(details);
        }
        public List<ProductDetailsModel> getProd()
        {
            List<ProductDetails> details = productRepo.findAll();
            return details.stream().map(l->productConversion(l)).collect(Collectors.toList());
        }

        public ProductDetailsModel productConversion(ProductDetails productDetails)
        {
            return new ProductDetailsModel(productDetails.getProductId(),productDetails.getName(),productDetails.getDescription());
        }
        public ProductSku addSku(ProductSkuModel productSkuModel,int productId)
        {
            ProductSku sku = new ProductSku();
            sku.setProductId(productId);
            sku.setSpecifications(productSkuModel.getSpecifications());
            return productSkuRepo.save(sku);
        }



    }
