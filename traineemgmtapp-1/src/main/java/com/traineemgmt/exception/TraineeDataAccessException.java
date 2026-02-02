package com.traineemgmt.exception;



public class TraineeDataAccessException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1858276334083064033L;

	public TraineeDataAccessException(String message, Throwable cause) {
        super(message, cause);
    }
}
