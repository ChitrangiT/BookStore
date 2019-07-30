package com.BookStore.Beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int bookId;
	private String bookName;
	private String auther;
	private int noOfCopies;
	private float price;
	
	public int getBookId() {
		return bookId;
	}
	
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuther() {
		return auther;
	}
	public void setAuther(String auther) {
		this.auther = auther;
	}
	public int getNoOfCopies() {
		return noOfCopies;
	}
	public void setNoOfCopies(int noOfCopies) {
		this.noOfCopies = noOfCopies;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	
}
