package com.book.checkout.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="promocode")
public class PromoCode {

	@Id
	private Long pCode;
	private float Discount;
	private String bookName;
	
	
	
	public PromoCode() {
		super();
	}
	
	public Long getpCode() {
		return pCode;
	}
	public void setpCode(Long pCode) {
		this.pCode = pCode;
	}
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
	public PromoCode(Long pCode, float discount, String bookName) {
		super();
		this.pCode = pCode;
		Discount = discount;
		this.bookName = bookName;
	}
	
	
	
}
