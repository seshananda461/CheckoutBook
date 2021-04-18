package com.book.checkout.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.book.checkout.dto.BookDto;
import com.book.checkout.dto.PromoCodeDto;
import com.book.checkout.entity.Book;
import com.book.checkout.entity.PromoCode;
import com.book.checkout.exceptions.BookDetailsNotFoundException;
import com.book.checkout.exceptions.BookNotFoundException;
import com.book.checkout.repository.BookRepository;
import com.book.checkout.repository.CheckoutRepository;
import com.book.checkout.service.BookService;

@Service
public class BookServiceImpl implements BookService{
	
	private static final Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);
	
	@Autowired 
	BookRepository bookRepository;
	
	@Autowired
	CheckoutRepository checkoutRepository;

	@Override
	@Transactional
	public String addBooks(List<BookDto> bookDto) {
		List<Book> bookList=new ArrayList<Book>();
		bookDto.stream().forEach(dtoList->{
			Book book = new Book();
			BeanUtils.copyProperties(dtoList, book);
			bookList.add(book);
		});
		bookRepository.saveAll(bookList);
		return "Books Added Successfully";
		
//		List<Book> book =bookDto.stream().map(new Function<BookDto,Book>(){
//		@Override
//		public Book apply(BookDto b) {
//			logger.info("Book Added");
//			return new Book(b.getBookId(),b.getBookName(),b.getBookDescription(),b.getBookAuthor(),b.getBookType(),b.getBookPrice(),b.getBookISBN());
//		}
//	}).collect(Collectors.toList());
	}

	@Override
	public List<BookDto> getAllBooks( int pageNumber, int pageSize) throws BookDetailsNotFoundException {
		Page<Book> book;
		List<BookDto> bookDtoList = new ArrayList<BookDto>();
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		book = bookRepository.findAll(pageable);
		if(book==null) {
			throw new BookDetailsNotFoundException("Book Details Not Found");
		}
		book.stream().forEach(bookRes -> {
			logger.info("All Books");
			BookDto bookDtoRes = new BookDto();
			BeanUtils.copyProperties(bookRes, bookDtoRes);
			bookDtoList.add(bookDtoRes);
		});
		return bookDtoList;
		
	}

	@Override
	public String removeBook(Long bookId) throws BookNotFoundException {
		Optional<Book> bookRes = bookRepository.findById(bookId);
		if(!bookRes.isPresent()) {
			throw new BookNotFoundException("Book Not Found");
		}
		Book book = bookRes.get();
		bookRepository.delete(book);
		return "Book Succesfully Deleted";
	}

	@Override
	public String updateBook(BookDto bookDto) {
			Optional<Book> bookRes = bookRepository.findById(bookDto.getBookId());
			Book book = bookRes.get();
			BeanUtils.copyProperties(bookDto, book);
			bookRepository.save(book);
			return "Book Succesfully Updated";
		}

	
	  @Override 
	  public String addPromos(List<PromoCodeDto> promoCodeDto) {
		  List<PromoCode> promoCodeList = new ArrayList<PromoCode> ();
		  promoCodeDto.stream().forEach(promoCodeDtos->{
		  PromoCode promoCode = new PromoCode();
		  BeanUtils.copyProperties(promoCodeDtos, promoCode);
		  promoCodeList.add(promoCode);
		  });
	     checkoutRepository.saveAll(promoCodeList);
	 
	     return "Promo Codes Added Successfully"; 
	  
//	  List<PromoCode> promoCode =promoCodeDto.stream().map(new
//	  Function<PromoCodeDto,PromoCode>(){
//	  
//	  @Override 
//	  public PromoCode apply(PromoCodeDto p) {
//	  logger.info("promo Added"); 
//	  return new PromoCode(p.getpCode(),p.getDiscount(),p.getBookName()); 
//	  }
//	  }).collect(Collectors.toList()); 
	  }
	 
	
	@Override
	public List<PromoCodeDto> getAllDetails(int pageNumber, int pageSize) {
		Page<PromoCode> promoCode;
		List<PromoCodeDto> promoCodeDtoList = new ArrayList<PromoCodeDto>();
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		promoCode = checkoutRepository.findAll(pageable);
		promoCode.stream().forEach(dtoList->{
		PromoCodeDto pDto = new PromoCodeDto();
		BeanUtils.copyProperties(dtoList, pDto);
		promoCodeDtoList.add(pDto);
		});
		return promoCodeDtoList;
	}
}




