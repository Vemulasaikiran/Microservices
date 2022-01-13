package com.example.ProductDetails.service;


import com.example.ProductDetails.entity.ProductDetails;
import com.example.ProductDetails.entity.ProductPrice;
import com.example.ProductDetails.entity.ProductSku;
import com.example.ProductDetails.model.ProductDetailsModel;
import com.example.ProductDetails.model.ProductPriceModel;
import com.example.ProductDetails.model.ProductSkuModel;
import com.example.ProductDetails.repository.ProductPriceRepo;
import com.example.ProductDetails.repository.ProductRepo;
import com.example.ProductDetails.repository.ProductSkuRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService
    {
        @Autowired
        private ProductRepo productRepo;
        @Autowired
        private ProductSkuRepo productSkuRepo;
        @Autowired
        private ProductPriceRepo priceRepo;



        public ProductDetails addProduct(ProductDetailsModel productModel)
        {
            ProductDetails details = new ProductDetails();
            details.setName(productModel.getName());
            details.setDescription(productModel.getDescription());
            return productRepo.save(details);
        }


        public String addSku(ProductSkuModel productSkuModel,int productId)
        {
            if(productRepo.findById(productId).isPresent()) {
                ProductSku sku = new ProductSku();
                sku.setProductId(productId);
                sku.setSpecifications(productSkuModel.getSpecifications());
                productSkuRepo.save(sku);
                return "Sku Added";
            }
            return "Product not found \nPlease Add product";
        }


        public String addPrice(ProductPriceModel productPriceModel, int productSkuId)
        {
            if(productSkuRepo.findById(productSkuId).isPresent()) {

                ProductPrice price = new ProductPrice();
                price.setSkuCode(productSkuId);
                price.setPriceCode(productPriceModel.getPriceCode());
                price.setCurrency(productPriceModel.getCurrency());
                price.setPrice(productPriceModel.getPrice());
                priceRepo.save(price);
                return "Product Price Added";
            }
            return "Sku is missing \n  please add productSku";
        }




        public List<ProductDetailsModel> getProd()
        {
            List<ProductDetails> details = productRepo.findAll();
            return details.stream().map(l->productConversion(l)).collect(Collectors.toList());
        }

        public List<ProductSkuModel> getSku()
        {
            List<ProductSku> sku = productSkuRepo.findAll();
            return sku.stream().map(this::skuConversion).collect(Collectors.toList());
        }

        public List getProductPrice()
        {
            List<ProductDetails> pD = productRepo.findAll();
            List<ProductSku> pS = productSkuRepo.findAll();
            List<ProductPrice> pP = priceRepo.findAll();
            List data = new ArrayList();
            data.add(pD.stream().map(this::productConversion).collect(Collectors.toList()));
            data.add(pS.stream().map(this::skuConversion).collect(Collectors.toList()));
            data.add(pP.stream().map(this::priceConversion).collect(Collectors.toList()));
            return data;
        }




        public ProductDetailsModel productConversion(ProductDetails productDetails)
        {
            return new ProductDetailsModel(productDetails.getProductId(),productDetails.getName(),productDetails.getDescription());
        }
        public ProductSkuModel skuConversion(ProductSku sku)
        {
            return new ProductSkuModel(sku.getProductSkuId(),sku.getProductId(),sku.getSpecifications());
        }
        public ProductPriceModel priceConversion(ProductPrice price)
        {
            return new ProductPriceModel(price.getPriceCode(),price.getSkuCode(),price.getCurrency(),price.getPrice());
        }









    }
