package com.book.checkout.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler{
	
	
	@ExceptionHandler(value=BookNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleCustomerNotFoundException(BookNotFoundException employeeDetailsNotFoundException){
		ErrorMessage errorMessage=new ErrorMessage();
		errorMessage.setErrorCode("Invalid Book ");
		errorMessage.setErrorMessage(employeeDetailsNotFoundException.getMessage());
		return new ResponseEntity<ErrorMessage>(errorMessage,HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(value=BookDetailsNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleCustomerNotFoundException(BookDetailsNotFoundException employeeDetailsNotFoundException){
		ErrorMessage errorMessage=new ErrorMessage();
		errorMessage.setErrorCode("Invalid Book Details");
		errorMessage.setErrorMessage(employeeDetailsNotFoundException.getMessage());
		
		return new ResponseEntity<ErrorMessage>(errorMessage,HttpStatus.BAD_REQUEST);
		
	}

}
