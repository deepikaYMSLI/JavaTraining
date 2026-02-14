package com.ymsli.bank.inhouse.exceptions;

public class InvalidTransactionStateException extends BankException{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5034520641602557745L;

	public InvalidTransactionStateException(String msg) {
		super(msg);
	}

}
