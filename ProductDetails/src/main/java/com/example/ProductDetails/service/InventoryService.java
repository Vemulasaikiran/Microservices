package com.example.ProductDetails.service;

import com.example.ProductDetails.entity.Inventory;
import com.example.ProductDetails.model.InventoryModel;
import com.example.ProductDetails.repository.InventoryRepo;
import com.example.ProductDetails.repository.ProductPriceRepo;
import com.example.ProductDetails.repository.ProductRepo;
import com.example.ProductDetails.repository.ProductSkuRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class InventoryService
    {
        @Autowired
        private InventoryRepo inventoryRepo;
        @Autowired
        private ProductRepo productRepo;
        @Autowired
        private ProductSkuRepo productSkuRepo;
        @Autowired
        private ProductPriceRepo priceRepo;

        public String addStock(InventoryModel inventoryModel, int productSkuId)
        {
            if (productSkuRepo.findById(productSkuId).isPresent()) {


                Inventory inv = new Inventory();
                inv.setProductSkuId(productSkuId);
                inv.setQuantityAvailable(inventoryModel.getQuantityAvailable());
                inventoryRepo.save(inv);
                return "Inventory Added";
            }
            return "Product Not Available";
        }

        public String updateStock(InventoryModel inventoryModel, int productSkuId)
        {
            if(!inventoryRepo.findByproductSkuId(productSkuId).isEmpty()) {


                List<Inventory> invo = inventoryRepo.findByproductSkuId(productSkuId);
                invo.stream().forEach(i ->
                {
                    i.setQuantityAvailable(inventoryModel.getQuantityAvailable());
                    inventoryRepo.save(i);
                });
                return "Product Updated";
            }
            return "Product Not Found";
        }






    }
