package com.traineemgmt.exception;
public class ResourceNotFoundException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 2322511214093355258L;

	public ResourceNotFoundException(String message) {
        super(message);
    }
}