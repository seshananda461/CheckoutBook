package com.book.checkout.service;

import java.util.List;

import com.book.checkout.dto.BookDto;
import com.book.checkout.dto.PromoCodeDto;
import com.book.checkout.exceptions.BookDetailsNotFoundException;
import com.book.checkout.exceptions.BookNotFoundException;

public interface BookService {
	
	
	/**
	 * 
	 * @param bookDto
	 * @return
	 */
	String addBooks(List<BookDto> bookDto);
	
	/**
	 * 
	 * @param bookId
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 * @throws BookDetailsNotFoundException 
	 */

	List<BookDto> getAllBooks( int pageNumber, int pageSize) throws BookDetailsNotFoundException;
	
	/**
	 * 
	 * @param bookId
	 * @return
	 * @throws BookNotFoundException 
	 */
	String removeBook(Long bookId) throws BookNotFoundException;
	
	/**
	 * 
	 * @param bookDto
	 * @param bookId
	 * @return
	 */

	String updateBook(BookDto bookDto);

	
	
	/**
	 * 
	 * @param promoCodeDto
	 * @return
	 */

	String addPromos(List<PromoCodeDto> promoCodeDto); 
	
	
	
	/**
	 * 
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	List<PromoCodeDto> getAllDetails(int pageNumber, int pageSize);

	

}
