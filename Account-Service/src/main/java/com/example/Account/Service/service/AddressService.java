package com.example.Account.Service.service;

import com.example.Account.Service.entity.BillingAddress;
import com.example.Account.Service.model.BillingAddressModel;
import com.example.Account.Service.repository.BillingRepo;
import com.example.Account.Service.repository.ShippingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressService {
    @Autowired
    private BillingRepo billingRepo;
    @Autowired
    private ShippingRepo shippingRepo;

    public BillingAddress addBilling(BillingAddressModel billingAddressModel,int customerId)
    {
        BillingAddress bAdd= new BillingAddress();
        bAdd.setCustomerId(customerId);
        bAdd.setLine_1(billingAddressModel.getLine_1());
        bAdd.setLine_2(billingAddressModel.getLine_2());
        bAdd.setPostalCode(billingAddressModel.getPostalCode());
        bAdd.setCity(billingAddressModel.getCity());
        bAdd.setState(billingAddressModel.getState());
        return billingRepo.save(bAdd);
    }


    public List<BillingAddressModel> getBilling()
    {
        List<BillingAddress> add= billingRepo.findAll();
       return add.stream().map(this::conversion).collect(Collectors.toList());
    }

    public BillingAddressModel conversion(BillingAddress bill)
    {
        return new BillingAddressModel(bill.getBillingId(),
                bill.getCustomerId(),bill.getLine_1(),bill.getLine_2(),
                bill.getPostalCode(),bill.getCity(),bill.getState());

    }




}
