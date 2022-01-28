package com.example.Account.Service.model;

import com.example.Account.Service.entity.BillingAddress;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AllDetails {
    private List<RegistrationModel> registrationDetails;
    private List<BillingAddressModel> billingDetails;
    private List<ShippingAddressModel> shippingDetails;


}
