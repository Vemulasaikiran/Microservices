package com.example.ProductDetails.repository;

import com.example.ProductDetails.entity.ProductDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<ProductDetails,Integer> {
//    boolean existsbyProductId(int productId);
}
