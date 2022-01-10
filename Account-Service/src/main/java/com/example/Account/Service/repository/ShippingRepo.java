package com.example.Account.Service.repository;

import com.example.Account.Service.entity.BillingAddress;
import com.example.Account.Service.entity.ShippingAddress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShippingRepo extends JpaRepository<ShippingAddress, Integer> {
    List<ShippingAddress> findByCustomerId(int customerId);

}
