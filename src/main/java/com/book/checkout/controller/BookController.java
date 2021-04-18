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
import com.book.checkout.dto.PromoCodeDto;
import com.book.checkout.exceptions.BookDetailsNotFoundException;
import com.book.checkout.exceptions.BookNotFoundException;
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
	 * @throws BookDetailsNotFoundException 
	 */
	@GetMapping("/getallbooks")
	public ResponseEntity<List<BookDto>> getAllBooks(@RequestParam int pageNumber, @RequestParam int pageSize) throws BookDetailsNotFoundException{
		List<BookDto> dtoRes=bookService.getAllBooks(pageNumber,pageSize);
		return new ResponseEntity<List<BookDto>>(dtoRes,HttpStatus.OK);
		
	}
	
	/**
	 * 
	 * @param bookId
	 * @return
	 * @throws BookNotFoundException 
	 */
	@DeleteMapping("/removingbook")
	public ResponseEntity<String> removeBook(@RequestParam Long bookId) throws BookNotFoundException{
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
	/**
	 * 
	 * @param promoCodeDto
	 * @return
	 */
	
	
	  @PostMapping("/addpromos") 
	  public ResponseEntity<String> addPromos(@RequestBody List<PromoCodeDto> promoCodeDto){
	  bookService.addPromos(promoCodeDto); 
	  return new ResponseEntity<String>("Promo codes Added",HttpStatus.CREATED);
	  
	  }
	 
	
	
	/**
	 * 
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	
	@GetMapping("/getalldetails")
	public ResponseEntity<List<PromoCodeDto>> getAllDetails(@RequestParam int pageNumber, @RequestParam int pageSize){
		List<PromoCodeDto> dtoList = bookService.getAllDetails(pageNumber,pageSize);
		return new ResponseEntity<List<PromoCodeDto>>(dtoList,HttpStatus.OK) ;
		
	}
}
