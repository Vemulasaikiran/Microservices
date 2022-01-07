package com.example.Account.Service.repository;

import com.example.Account.Service.entity.BillingAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillingAddressRepo extends JpaRepository<BillingAddress, Integer> {
}
