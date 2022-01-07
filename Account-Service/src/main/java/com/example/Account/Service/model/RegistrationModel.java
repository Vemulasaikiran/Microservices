package com.example.Account.Service.model;

import com.example.Account.Service.entity.BillingAddress;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter

public class RegistrationModel {


    private int id;
    private String name;
    private String email;
    private long mobile_number;
    private String password;
//    private List<ShippingAddressModel> shippingAddress;
//    private List<BillingAddressModel>billingAddress;


}
