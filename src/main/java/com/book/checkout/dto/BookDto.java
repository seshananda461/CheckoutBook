package com.book.checkout.dto;

public class BookDto {
	
	private Long bookId;
    private String bookName;
    private String bookDescription;
    private String bookAuthor;
    private String bookType;
    private Long bookPrice;
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
