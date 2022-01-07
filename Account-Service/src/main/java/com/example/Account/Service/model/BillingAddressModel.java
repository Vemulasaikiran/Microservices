package com.example.Account.Service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.criteria.CriteriaBuilder;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BillingAddressModel
{
    private int billingId;
    private Integer customerId;
    private String Line_1;
    private String Line_2;
    private int postalCode;
    private String city;
    private String state;

}
