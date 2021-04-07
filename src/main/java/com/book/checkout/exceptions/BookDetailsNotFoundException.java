package com.book.checkout.exceptions;

public class BookDetailsNotFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public BookDetailsNotFoundException(String message) {
		super(message);
	}

}
