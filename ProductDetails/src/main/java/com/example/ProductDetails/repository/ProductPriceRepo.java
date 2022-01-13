package com.example.ProductDetails.repository;

import com.example.ProductDetails.entity.ProductPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductPriceRepo extends JpaRepository<ProductPrice,Integer> {

}
