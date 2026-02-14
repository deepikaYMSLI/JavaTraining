package com.ymsli.bank.inhouse.service.impl;

import com.ymsli.bank.inhouse.exceptions.ResourceNotFoundException;
import com.ymsli.bank.inhouse.model.Account;
import com.ymsli.bank.inhouse.repository.AccountRepository;
import com.ymsli.bank.inhouse.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AccountServiceImpl implements AccountService {

  private final AccountRepository accountRepository;
    public AccountServiceImpl(AccountRepository accountRepository) {
    	this.accountRepository=accountRepository;
    }
   

    @Override
    public Account createAccount() {
        Account account = new Account();
        account.setAccountNumber(UUID.randomUUID().toString());
        account.setBalance(0.0);
        return accountRepository.save(account);
    }

    @Override
    public Account getAccount(String accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found with Account Number:"+ accountNumber));
    }
}
