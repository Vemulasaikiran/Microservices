package com.example.Cart.Service.controller;

import com.example.Cart.Service.model.CartInput;
import com.example.Cart.Service.model.CartModel;
import com.example.Cart.Service.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartController {
    @Autowired
    public CartService cartService;

    @PostMapping("/add-to-cart")
    public String addCart(@RequestBody CartInput cartInput)
    {
        return cartService.addCart(cartInput);
    }
    @GetMapping("/get-cart")
    public List<CartModel> get()
    {
        return cartService.getCart();
    }
}
