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
import com.book.checkout.entity.Book;
import com.book.checkout.repository.BookRepository;
import com.book.checkout.service.BookService;

@Service
public class BookServiceImpl implements BookService{
	
	private static final Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);
	
	@Autowired 
	BookRepository bookRepository;

	@Override
	@Transactional
	public String addBooks(List<BookDto> bookDto) {
		List<Book> book =bookDto.stream().map(new Function<BookDto,Book>(){
			@Override
			public Book apply(BookDto b) {
				logger.info("Book Added");
				return new Book(b.getBookId(),b.getBookName(),b.getBookDescription(),b.getBookAuthor(),b.getBookType(),b.getBookPrice(),b.getBookISBN());
			}
		}).collect(Collectors.toList());
		bookRepository.saveAll(book);
		return "Books Added Successfully";
	}

	@Override
	public List<BookDto> getAllBooks(Long bookId, int pageNumber, int pageSize) {
		Page<Book> book;
		List<BookDto> bookDtoList = new ArrayList<BookDto>();
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		book = bookRepository.findByBookId(bookId,pageable);
		book.stream().forEach(bookRes -> {
			BookDto bookDtoRes = new BookDto();
			BeanUtils.copyProperties(bookRes, bookDtoRes);
			bookDtoList.add(bookDtoRes);
		});
		return bookDtoList;
		
	}

	@Override
	public String removeBook(Long bookId) {
		Optional<Book> bookRes = bookRepository.findById(bookId);
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
	}

	


