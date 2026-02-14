package com.ymsli.bank.inhouse.controller;

import com.ymsli.bank.inhouse.model.Account;
import com.ymsli.bank.inhouse.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/create")
    public Account createAccount() {
        return accountService.createAccount();
    }
}
