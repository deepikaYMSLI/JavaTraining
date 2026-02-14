package com.ymsli.bank.inhouse.service;

import com.ymsli.bank.inhouse.model.Account;

public interface AccountService {
    Account createAccount();
    Account getAccount(String accountNumber);
}
