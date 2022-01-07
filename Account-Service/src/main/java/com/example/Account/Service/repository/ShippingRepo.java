package com.example.Account.Service.repository;

import com.example.Account.Service.entity.ShippingAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShippingRepo extends JpaRepository<ShippingAddress, Integer> {
}
