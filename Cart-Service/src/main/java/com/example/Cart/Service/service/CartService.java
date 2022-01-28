package com.example.Cart.Service.service;

import com.example.Cart.Service.entity.Cart;
import com.example.Cart.Service.model.CartInput;
import com.example.Cart.Service.model.CartModel;
import com.example.Cart.Service.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartService {
    @Autowired
    public CartRepository cartRepository;
    public String addCart(CartInput cartInput)
    {
        Cart cart =new Cart();
        cart.setCustomerId(cartInput.getCustomerId());
        cart.setProductId(cartInput.getProductId());
        cart.setProductSkuId(cartInput.getProductSkuId());
        cart.setQuantity(cartInput.getQuantity());
        cartRepository.save(cart);
        return "Product Added to Cart";

    }
    public List<CartModel> getCart()
    {
        List<Cart> cart =cartRepository.findAll();
        return  cart.stream().map(this::cartConversion).collect(Collectors.toList());

    }
    public CartModel cartConversion(Cart cart)
    {
        CartModel  mod = new CartModel();
        mod.setCartId(cart.getCartId());
        mod.setCustomerId(cart.getCustomerId());
        mod.setProductId(cart.getProductId());
        mod.setProductSkuId(cart.getProductSkuId());
        mod.setQuantity(cart.getQuantity());
        return mod;
    }

}
