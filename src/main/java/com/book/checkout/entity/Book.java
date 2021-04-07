package com.book.checkout.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="checkbook")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookId;
    private String bookName;
    private String bookDescription;
    private String bookAuthor;
    private String bookType;
    private Long bookPrice;
    private Long bookISBN;
    
    
	public Book() {
		super();
		
	}
	public Long getBookId() {
		return bookId;
	}
	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookDescription() {
		return bookDescription;
	}
	public void setBookDescription(String bookDescription) {
		this.bookDescription = bookDescription;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public String getBookType() {
		return bookType;
	}
	public void setBookType(String bookType) {
		this.bookType = bookType;
	}
	public Long getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(Long bookPrice) {
		this.bookPrice = bookPrice;
	}
	public Long getBookISBN() {
		return bookISBN;
	}
	public void setBookISBN(Long bookISBN) {
		this.bookISBN = bookISBN;
	}
	public Book(Long bookId, String bookName, String bookDescription, String bookAuthor, String bookType,
			Long bookPrice, Long bookISBN) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookDescription = bookDescription;
		this.bookAuthor = bookAuthor;
		this.bookType = bookType;
		this.bookPrice = bookPrice;
		this.bookISBN = bookISBN;
	}
	
    
}