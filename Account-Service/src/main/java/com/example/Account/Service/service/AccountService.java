package com.example.Account.Service.service;

import com.example.Account.Service.entity.Registration;
import com.example.Account.Service.model.LoginModel;
import com.example.Account.Service.model.RegistrationModel;
import com.example.Account.Service.repository.RegistrationRepo;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class AccountService {
    @Autowired
    public RegistrationRepo registrationRepo;


    public String add(RegistrationModel registrationModel) {
//        List<Registration> ema = registrationRepo.findAll();
        if (!registrationRepo.existsByEmail(registrationModel.getEmail())) {
            Registration reg = new Registration();

            reg.setId(registrationModel.getId());
            reg.setName(registrationModel.getName());
            reg.setEmail(registrationModel.getEmail());
            reg.setMobile_number(registrationModel.getMobile_number());


            //******Password Encryption ********//
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

            registrationRepo.save(reg);

            return "User Added";
        }

        return "User Already exist";
    }


    public List<RegistrationModel> get() {
        List<Registration> reg = registrationRepo.findAll();
        return reg.stream().map(this::registrationConversion).collect(Collectors.toList());
    }

    public RegistrationModel registrationConversion(Registration registration) {
        RegistrationModel regModel = new RegistrationModel();
        regModel.setId(registration.getId());
        regModel.setName(registration.getName());
        regModel.setEmail(registration.getEmail());
        regModel.setMobile_number(registration.getMobile_number());

        //******Password Decryption  ********//

//        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
//        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
//        config.setPassword("cjss_encryption"); // encryptor's private key
//        config.setPoolSize("1");
//        encryptor.setConfig(config);
//        String obj = encryptor.decrypt(registration.getPassword());
//
//
//        regModel.setPassword(obj);
        return regModel;
    }


    public String login(LoginModel loginModel) {
        if (registrationRepo.existsByEmail(loginModel.getEmail()))
        {


            Registration reg = registrationRepo.findByEmail(loginModel.getEmail());
            PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
            SimpleStringPBEConfig config = new SimpleStringPBEConfig();
            config.setPassword("cjss_encryption"); // encryptor's private key
            config.setPoolSize("1");
            encryptor.setConfig(config);
            String pass = encryptor.decrypt(reg.getPassword());

            if (loginModel.getPassword().equals(pass))
            {
                return "Logged In";
            }
            System.out.println(reg.getPassword());
            System.out.println(pass);

            return "Please check your Password";
//
//        if(encryptor.decrypt(reg.getPassword()).equals(password))
//        {
//            return "Login Successful";
//        }
        }
        return "Please check your email Id";
    }
}