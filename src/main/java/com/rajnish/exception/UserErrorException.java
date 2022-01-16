package com.rajnish.exception;

public class UserErrorException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserErrorException() {
		super();
	}
	
	public UserErrorException(String message) {
		super(message);
	}
}
