package com.example.ProductDetails.repository;

import com.example.ProductDetails.entity.ProductDetails;
import com.example.ProductDetails.entity.ProductSku;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductSkuRepo extends JpaRepository<ProductSku,Integer> {

}
