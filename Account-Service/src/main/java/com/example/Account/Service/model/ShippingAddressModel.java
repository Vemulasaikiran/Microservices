package com.example.Account.Service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ShippingAddressModel
{
    private String email;
    private String Line_1;
    private String Line_2;
    private int postalCode;
    private String city;
    private String state;
}
