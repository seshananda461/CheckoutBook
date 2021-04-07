package com.book.checkout.service;

import java.util.List;

import com.book.checkout.dto.BookDto;

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
	 */

	List<BookDto> getAllBooks(Long bookId, int pageNumber, int pageSize);
	
	/**
	 * 
	 * @param bookId
	 * @return
	 */
	String removeBook(Long bookId);
	
	/**
	 * 
	 * @param bookDto
	 * @param bookId
	 * @return
	 */

	String updateBook(BookDto bookDto);
	
	

}
