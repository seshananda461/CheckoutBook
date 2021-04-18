package com.book.checkout.exceptions;

public class InvalidPromoCodeException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public InvalidPromoCodeException(String message) {
		super(message);
	}

}
