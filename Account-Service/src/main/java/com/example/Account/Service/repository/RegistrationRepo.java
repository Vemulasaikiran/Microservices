package com.example.Account.Service.repository;

import com.example.Account.Service.entity.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepo extends JpaRepository<Registration, Integer> {
    Registration findByEmail(String email);
    boolean existsByEmail(String email);
}
