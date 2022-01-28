package com.example.Account.Service.service;

import com.example.Account.Service.entity.BillingAddress;
import com.example.Account.Service.entity.Registration;
import com.example.Account.Service.entity.ShippingAddress;
import com.example.Account.Service.model.AllDetails;
import com.example.Account.Service.model.BillingAddressModel;
import com.example.Account.Service.model.LoginModel;
import com.example.Account.Service.model.ShippingAddressModel;
import com.example.Account.Service.repository.BillingRepo;
import com.example.Account.Service.repository.RegistrationRepo;
import com.example.Account.Service.repository.ShippingRepo;
import com.example.Account.Service.token.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AddressService {
    @Autowired
    private TokenService tokenService;
    @Autowired
    private BillingRepo billingRepo;
    @Autowired
    private ShippingRepo shippingRepo;
    @Autowired
    private RegistrationRepo registrationRepo;
    @Autowired
    private AccountService accountService;

    public ResponseEntity<String> addBilling(BillingAddressModel billingAddressModel, int customerId, String token)
    {
        if(tokenService.validToken(token)) {
            BillingAddress bAdd = new BillingAddress();
            bAdd.setCustomerId(customerId);
            bAdd.setLine_1(billingAddressModel.getLine_1());
            bAdd.setLine_2(billingAddressModel.getLine_2());
            bAdd.setPostalCode(billingAddressModel.getPostalCode());
            bAdd.setCity(billingAddressModel.getCity());
            bAdd.setState(billingAddressModel.getState());
            billingRepo.save(bAdd);
            return ResponseEntity.status(HttpStatus.CREATED).body("BillingAddress Added Successfully. \n");
        }
        else if(token.isEmpty())
        {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Encryption Token Required.");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Enter Valid Token.");
    }
    public ResponseEntity<String> addShipping(ShippingAddressModel shippingAddressModel,int customerId,String token)
    {
        if(tokenService.validToken(token))
        {
            ShippingAddress sAddress = new ShippingAddress();
            sAddress.setCustomerId(customerId);
            sAddress.setLine_1(shippingAddressModel.getLine_1());
            sAddress.setLine_2(shippingAddressModel.getLine_2());
            sAddress.setPostalCode(shippingAddressModel.getPostalCode());
            sAddress.setCity(shippingAddressModel.getCity());
            sAddress.setState(shippingAddressModel.getState());
            shippingRepo.save(sAddress);
            return ResponseEntity.status(HttpStatus.CREATED).body("ShippingAddress Added Successfully. \n");
        }
        else if(token.isEmpty())
        {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Encryption Token Required.");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Enter Valid Token.");

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
    public AllDetails getall(int id)
    {
            AllDetails details = new AllDetails();
            Optional<Registration> reg = registrationRepo.findById(id);
            List<BillingAddress> bill = billingRepo.findByCustomerId(id);
            List<ShippingAddress> ship = shippingRepo.findByCustomerId(id);

            details.setRegistrationDetails(reg.stream().map(t -> accountService.registrationConversion(t)).collect(Collectors.toList()));
            details.setBillingDetails(bill.stream().map(this::billingConversion).collect(Collectors.toList()));
            details.setShippingDetails(ship.stream().map(this::shippingConversion).collect(Collectors.toList()));
            return details;
    }
}
