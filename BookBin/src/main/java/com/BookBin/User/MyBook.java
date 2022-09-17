package com.BookBin.User;

public class MyBook 
{
	String book_id;
	String book_status;
	String book_title;
	String book_author; 
	String book_publisher;
	String book_edition;
	String book_price;
	String book_description;
	String published_year ;
	String  customer_id ;
	
	
	public MyBook(String book_id, String book_status, String book_title, String book_author, String book_publisher,
			String book_edition, String book_price, String book_description, String published_year,
			String customer_id) {
		super();
		this.book_id = book_id;
		this.book_status = book_status;
		this.book_title = book_title;
		this.book_author = book_author;
		this.book_publisher = book_publisher;
		this.book_edition = book_edition;
		this.book_price = book_price;
		this.book_description = book_description;
		this.published_year = published_year;
		this.customer_id = customer_id;
	}
	
	
	public MyBook(String book_id, String book_title,  String book_author, String book_price, String customer_id) {
		super();
		this.book_id = book_id;
		this.book_title = book_title;
		this.book_author = book_author;
		this.book_price = book_price;
		this.customer_id = customer_id;
	}
	
	
	
	public String getBook_id() {
		return book_id;
	}
	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}
	public String getBook_status() {
		return book_status;
	}
	public void setBook_status(String book_status) {
		this.book_status = book_status;
	}
	public String getBook_title() {
		return book_title;
	}
	public void setBook_title(String book_title) {
		this.book_title = book_title;
	}
	public String getBook_author() {
		return book_author;
	}
	public void setBook_author(String book_author) {
		this.book_author = book_author;
	}
	public String getBook_publisher() {
		return book_publisher;
	}
	public void setBook_publisher(String book_publisher) {
		this.book_publisher = book_publisher;
	}
	public String getBook_edition() {
		return book_edition;
	}
	public void setBook_edition(String book_edition) {
		this.book_edition = book_edition;
	}
	public String getBook_price() {
		return book_price;
	}
	public void setBook_price(String book_price) {
		this.book_price = book_price;
	}
	public String getBook_description() {
		return book_description;
	}
	public void setBook_description(String book_description) {
		this.book_description = book_description;
	}
	public String getPublished_year() {
		return published_year;
	}
	public void setPublished_year(String published_year) {
		this.published_year = published_year;
	}
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	
	
	
	
	
}
