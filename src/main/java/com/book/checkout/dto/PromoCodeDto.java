package com.book.checkout.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class PromoCodeDto {
	
	@Digits(integer = 6, fraction = 1, message = "Promo Code should be less than 6 digits")
	private Long pCode;
	@NotNull(message = "Discount Must not be null")
	private float Discount;
	@NotEmpty(message = "Book Name Must not be Empty")
	private String bookName;
	
	public float getDiscount() {
		return Discount;
	}
	public void setDiscount(float discount) {
		Discount = discount;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public Long getpCode() {
		return pCode;
	}
	public void setpCode(Long pCode) {
		this.pCode = pCode;
	}

}
