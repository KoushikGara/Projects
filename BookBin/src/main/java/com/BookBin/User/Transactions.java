package com.BookBin.User;

public class Transactions 
{
	String trans_id;
	String trans_status;
	String receiver_id;
	String owner_id;
	String book_id;
	String book_title;
	String trans_amount;
	String issued_date;
	String remaining_days;
	
	
	public Transactions(String trans_id, String trans_status, String receiver_id, String owner_id, String book_id,
			String book_title, String trans_amount, String issued_date, String remaining_days) {
		super();
		this.trans_id = trans_id;
		this.trans_status = trans_status;
		this.receiver_id = receiver_id;
		this.owner_id = owner_id;
		this.book_id = book_id;
		this.book_title = book_title;
		this.trans_amount = trans_amount;
		this.issued_date = issued_date;
		this.remaining_days = remaining_days;
	}
	
	public Transactions(String trans_id, String trans_status, String receiver_id, String book_id,
			String book_title, String trans_amount, String remaining_days) {
		super();
		this.trans_id = trans_id;
		this.trans_status = trans_status;
		this.receiver_id = receiver_id;
		//this.owner_id = owner_id;
		this.book_id = book_id;
		this.book_title = book_title;
		this.trans_amount = trans_amount;
		this.remaining_days = remaining_days;
	}
	
	
	public String getBook_title() {
		return book_title;
	}

	public void setBook_title(String book_title) {
		this.book_title = book_title;
	}
	
	
	public String getTrans_id() {
		return trans_id;
	}
	public void setTrans_id(String trans_id) {
		this.trans_id = trans_id;
	}
	public String getTrans_status() {
		return trans_status;
	}
	public void setTrans_status(String trans_status) {
		this.trans_status = trans_status;
	}
	public String getReceiver_id() {
		return receiver_id;
	}
	public void setReceiver_id(String receiver_id) {
		this.receiver_id = receiver_id;
	}
	public String getOwner_id() {
		return owner_id;
	}
	public void setOwner_id(String owner_id) {
		this.owner_id = owner_id;
	}
	public String getBook_id() {
		return book_id;
	}
	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}
	public String getTrans_amount() {
		return trans_amount;
	}
	public void setTrans_amount(String trans_amount) {
		this.trans_amount = trans_amount;
	}
	public String getIssued_date() {
		return issued_date;
	}
	public void setIssued_date(String issued_date) {
		this.issued_date = issued_date;
	}
	public String getRemaining_days() {
		return remaining_days;
	}
	public void setRemaining_days(String remaining_days) {
		this.remaining_days = remaining_days;
	}
	
    
}
