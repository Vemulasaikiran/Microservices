package com.example.Account.Service.controller;

import com.example.Account.Service.entity.BillingAddress;
import com.example.Account.Service.model.BillingAddressModel;
import com.example.Account.Service.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AddressController {
    @Autowired
    private AddressService addressService;

    @PostMapping("/add-billing-address/{customerId}")
    public BillingAddress addBillingAdd(@RequestBody BillingAddressModel billingAddressModel, @PathVariable Integer customerId)
    {
        return addressService.addBilling(billingAddressModel,customerId);

    }
}
