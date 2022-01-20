package com.example.ProductDetails.repository;

import com.example.ProductDetails.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InventoryRepo extends JpaRepository<Inventory, Integer> {
    List<Inventory> findByproductSkuId(int productSkuId);
}
