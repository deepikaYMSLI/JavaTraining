package com.bookstore.exception;

public class BookDataAccessException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1858276334083064033L;

	public BookDataAccessException(String message, Throwable cause) {
        super(message, cause);
    }
}
