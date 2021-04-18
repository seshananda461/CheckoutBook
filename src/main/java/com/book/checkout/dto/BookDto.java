package com.book.checkout.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;

public class BookDto {
	
	@Digits(integer = 6, fraction = 1, message = "Book Id should be less than 6 digits")
	private Long bookId;
	@NotEmpty(message = "Book Name Must not be Empty")
    private String bookName;
	@NotEmpty(message = "Book Description Must not be Empty")
    private String bookDescription;
	@NotEmpty(message = "Book Author Must not be Empty")
    private String bookAuthor;
	@NotEmpty(message = "Book Type Must not be Empty")
    private String bookType;
	@Digits(integer = 6, fraction = 1, message = "Book price should be less than 6 digits")
    private Long bookPrice;
	@Digits(integer = 6, fraction = 1, message = "Book ISBN should be less than 6 digits")
    private Long bookISBN;
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
	
    

}
