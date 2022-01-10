package com.example.Account.Service.controller;

import com.example.Account.Service.entity.Registration;
import com.example.Account.Service.model.RegistrationModel;
import com.example.Account.Service.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class AccountController {

    @Autowired
    public AccountService accountService;

    @PostMapping("/add")
    public String addVal(@Valid @RequestBody RegistrationModel registrationModel)
    {
        return accountService.add(registrationModel);

    }

    @GetMapping("/get")
    public List<RegistrationModel> getVal()
    {
        return accountService.get();
    }

}
