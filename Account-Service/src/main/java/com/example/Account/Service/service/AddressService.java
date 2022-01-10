package com.example.Account.Service.service;

import com.example.Account.Service.entity.BillingAddress;
import com.example.Account.Service.entity.Registration;
import com.example.Account.Service.entity.ShippingAddress;
import com.example.Account.Service.model.BillingAddressModel;
import com.example.Account.Service.model.ShippingAddressModel;
import com.example.Account.Service.repository.BillingRepo;
import com.example.Account.Service.repository.RegistrationRepo;
import com.example.Account.Service.repository.ShippingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AddressService {
    @Autowired
    private BillingRepo billingRepo;
    @Autowired
    private ShippingRepo shippingRepo;
    @Autowired
    private RegistrationRepo registrationRepo;
    @Autowired
    private AccountService accountService;

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
    public ShippingAddress addShipping(ShippingAddressModel shippingAddressModel,int customerId)
    {
        ShippingAddress sAddress = new ShippingAddress();
        sAddress.setCustomerId(customerId);
        sAddress.setLine_1(shippingAddressModel.getLine_1());
        sAddress.setLine_2(shippingAddressModel.getLine_2());
        sAddress.setPostalCode(shippingAddressModel.getPostalCode());
        sAddress.setCity(shippingAddressModel.getCity());
        sAddress.setState(shippingAddressModel.getState());
        return shippingRepo.save(sAddress);

    }

    public List<BillingAddressModel> getBilling()
    {
        List<BillingAddress> add= billingRepo.findAll();
       return add.stream().map(this::billingConversion).collect(Collectors.toList());
    }
    public List<ShippingAddressModel> getShipping()
    {
        List<ShippingAddress> ship = shippingRepo.findAll();
        return ship.stream().map(this::shippingConversion).collect(Collectors.toList());
    }
    public ShippingAddressModel shippingConversion(ShippingAddress shp)
    {
        return new ShippingAddressModel(shp.getShippingId(),shp.getCustomerId(), shp.getLine_1(),
                                        shp.getLine_2(),shp.getPostalCode(),shp.getCity(),shp.getState());

    }

    public BillingAddressModel billingConversion(BillingAddress bill)
    {
        return new BillingAddressModel(bill.getBillingId(),
                bill.getCustomerId(),bill.getLine_1(),bill.getLine_2(),
                bill.getPostalCode(),bill.getCity(),bill.getState());

    }
    public List getall(int id)
    {
        List allDetails = new ArrayList();
        Optional<Registration> reg = registrationRepo.findById(id);
        allDetails.add(reg.stream().map(t->accountService.registrationConversion(t)).collect(Collectors.toList()));
        List<BillingAddress> bill = billingRepo.findByCustomerId(id);
        allDetails.add(bill.stream().map(this::billingConversion).collect(Collectors.toList()));
        List<ShippingAddress> ship = shippingRepo.findByCustomerId(id);
        allDetails.add(ship.stream().map(this::shippingConversion).collect(Collectors.toList()));

        return allDetails;
    }
}
