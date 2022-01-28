package com.example.Cart.Service.repository;

import com.example.Cart.Service.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
}
