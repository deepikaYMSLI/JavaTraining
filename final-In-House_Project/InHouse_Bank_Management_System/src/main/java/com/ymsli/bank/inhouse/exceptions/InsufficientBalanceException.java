package com.ymsli.bank.inhouse.exceptions;

public class InsufficientBalanceException extends BankException{
	public InsufficientBalanceException(String msg) {
		super(msg);
	}

}
