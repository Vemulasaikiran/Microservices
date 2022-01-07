package com.example.Account.Service.service;

import com.example.Account.Service.entity.Registration;
import com.example.Account.Service.model.RegistrationModel;
import com.example.Account.Service.repository.RegistrationRepo;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountService {
    @Autowired
    public RegistrationRepo registrationRepo;
//    @Autowired
//    public BillingAddressRepo billingAddressRepo;
//    @Autowired
//    public ShippingAddressRepo shippingAddressRepo;


    public Registration add(RegistrationModel registrationModel)
    {
        Registration reg = new Registration();
        reg.setId(registrationModel.getId());
        reg.setName(registrationModel.getName());
        reg.setEmail(registrationModel.getEmail());
        reg.setMobile_number(registrationModel.getMobile_number());


        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();

        config.setPassword("cjss_encryption"); // encryptor's private key

        config.setAlgorithm("PBEWithMD5AndDES");
        config.setKeyObtentionIterations("1000");
        config.setPoolSize("1");
        config.setProviderName("SunJCE");
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setStringOutputType("base64");
        encryptor.setConfig(config);
        String encryptedData = encryptor.encrypt(registrationModel.getPassword());

        reg.setPassword(encryptedData);
//
//        reg.setBillingAddress(registrationModel.getBillingAddress());
//        reg.setShippingAddress(registrationModel.getShippingAddress());
        return registrationRepo.save(reg);
    }
    public List<RegistrationModel> get()
    {
        List<Registration> reg = registrationRepo.findAll();
        return reg.stream().map(this::conversion).collect(Collectors.toList());

    }




    public RegistrationModel conversion(Registration registration)
    {
        RegistrationModel regModel = new RegistrationModel();
        regModel.setId(registration.getId());
        regModel.setName(registration.getName());
        regModel.setEmail(registration.getEmail());
        regModel.setMobile_number(registration.getMobile_number());

//        regModel.setBillingAddress(registration.getBillingAddress());
//        regModel.setShippingAddress(registration.getShippingAddress());

//
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword("cjss_encryption"); // encryptor's private key
        config.setPoolSize("1");
        encryptor.setConfig(config);
        regModel.setPassword(encryptor.decrypt(registration.getPassword()));
        return regModel;
    }
}
