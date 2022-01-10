package com.example.Account.Service.controller;

import com.example.Account.Service.entity.BillingAddress;
import com.example.Account.Service.entity.Registration;
import com.example.Account.Service.entity.ShippingAddress;
import com.example.Account.Service.model.BillingAddressModel;
import com.example.Account.Service.model.ShippingAddressModel;
import com.example.Account.Service.service.AccountService;
import com.example.Account.Service.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressController {
    @Autowired
    private AddressService addressService;
    @Autowired
    private AccountService accountService;


    @PostMapping("/add-billing-address/{customerId}")
    public BillingAddress addBillingAdd(@RequestBody BillingAddressModel billingAddressModel, @PathVariable Integer customerId)
    {
        return addressService.addBilling(billingAddressModel,customerId);

    }
    @PostMapping("/add-shipping-address/{customerId}")
    public ShippingAddress addShipping(@RequestBody ShippingAddressModel shippingAddressModel,@PathVariable Integer customerId)
    {
        return addressService.addShipping(shippingAddressModel,customerId);
    }
    @GetMapping("/get-ship")
    private List<ShippingAddressModel> getShip()
    {
        return addressService.getShipping();
    }

    @GetMapping("/getall/{customerId}")
    public List getReg(@PathVariable int customerId)
    {
        return addressService.getall(customerId);
    }




}
