package com.book.checkout.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.book.checkout.dto.BookDto;
import com.book.checkout.service.BookService;



/**
 * 
 * @author seshananda
 *
 */
@RestController
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	BookService bookService;
	/**
	 * 
	 * @param bookDto
	 * @return
	 */
	
	@PostMapping("/addbooks")
	public ResponseEntity<String> addBooks(@RequestBody List<BookDto> bookDto){
		bookService.addBooks(bookDto);
		return new ResponseEntity<String> ("Book Successfully added",HttpStatus.CREATED);
	}
	
	/**
	 * 
	 * @param bookId
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	@GetMapping("getallbooks")
	public ResponseEntity<List<BookDto>> getAllBooks(@RequestParam Long bookId,@RequestParam int pageNumber, @RequestParam int pageSize){
		List<BookDto> dtoRes=bookService.getAllBooks(bookId,pageNumber,pageSize);
		return new ResponseEntity<List<BookDto>>(dtoRes,HttpStatus.OK);
		
	}
	
	/**
	 * 
	 * @param bookId
	 * @return
	 */
	@DeleteMapping("/removingbook")
	public ResponseEntity<String> removeBook(@RequestParam Long bookId){
		bookService.removeBook(bookId);
		return new ResponseEntity<String>("Book Successfully Deleted",HttpStatus.ACCEPTED);
		
	}
	/**
	 * 
	 * @param bookDto
	 * @param bookId
	 * @return
	 */
	@PutMapping("/updatebook")
	public ResponseEntity<String> updateBook(@RequestBody BookDto bookDto){
		bookService.updateBook(bookDto);
		return new ResponseEntity<String>("Book Updated Successfully",HttpStatus.ACCEPTED);
		
	}
	
}
