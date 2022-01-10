package com.example.Account.Service.repository;

import com.example.Account.Service.entity.BillingAddress;
import com.example.Account.Service.entity.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BillingRepo extends JpaRepository<BillingAddress, Integer> {
    List<BillingAddress> findByCustomerId(int customerId);

}
