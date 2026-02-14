package com.ymsli.bank.inhouse.repository;

import com.ymsli.bank.inhouse.model.Transaction;
import com.ymsli.bank.inhouse.model.enums.TransactionStatus;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
	//List<Transaction> findBystatus(Transaction transaction);
	//List<Transaction> findByaccountNumber(String accountNumber);
	//List<Transaction> findByFromAccountNumberOrToAccountNumber(String fromAccountNumber, String toAccountNumber);
	List<Transaction> findByStatus(TransactionStatus status);
	
}
