package com.example.Account.Service.controller;

import com.example.Account.Service.entity.BillingAddress;
import com.example.Account.Service.entity.Registration;
import com.example.Account.Service.entity.ShippingAddress;
import com.example.Account.Service.model.AllDetails;
import com.example.Account.Service.model.BillingAddressModel;
import com.example.Account.Service.model.LoginModel;
import com.example.Account.Service.model.ShippingAddressModel;
import com.example.Account.Service.service.AccountService;
import com.example.Account.Service.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressController {
    @Autowired
    private AddressService addressService;
    @Autowired
    private AccountService accountService;


    @PostMapping("/add-billing-address/{customerId}")
    public ResponseEntity<String> addBillingAdd(@RequestBody BillingAddressModel billingAddressModel, @PathVariable Integer customerId, @RequestHeader String token)
    {

        return addressService.addBilling(billingAddressModel,customerId,token);

    }
    @PostMapping("/add-shipping-address/{customerId}")
    public ResponseEntity<String> addShipping(@RequestBody ShippingAddressModel shippingAddressModel, @PathVariable Integer customerId, @RequestHeader String token)
    {
        return addressService.addShipping(shippingAddressModel,customerId,token);
    }
    @GetMapping("/get-ship")
    private List<ShippingAddressModel> getShip()
    {
        return addressService.getShipping();
    }

    @GetMapping("/getall/{customerId}")
    public AllDetails getReg(@PathVariable int customerId)
    {
        return addressService.getall(customerId);
    }




}
