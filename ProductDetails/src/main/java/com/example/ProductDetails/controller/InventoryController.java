package com.example.ProductDetails.controller;

import com.example.ProductDetails.model.InventoryModel;
import com.example.ProductDetails.service.InventoryService;
import com.example.ProductDetails.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.*;

@RestController

public class InventoryController {
    @Autowired
    public ProductService productService;
    @Autowired
    public InventoryService inventoryService;

    @PostMapping("/add-inventory/{productSkuId}")
    private String addInventory(@RequestBody InventoryModel inventoryModel, @PathVariable int productSkuId)
    {
        return inventoryService.addStock(inventoryModel,productSkuId);
    }

    @PutMapping("/updtae/{productSkuId}")
    public String update( @RequestBody InventoryModel inventoryModel,@PathVariable int productSkuId)
    {
        return inventoryService.updateStock( inventoryModel,productSkuId);
    }

}
