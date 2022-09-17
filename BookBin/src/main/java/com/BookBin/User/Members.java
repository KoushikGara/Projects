package com.BookBin.User;

public class Members 
{
	String username;	
	String email ;
	String mobile_number ;
	String pswd ;
	String user_type ;
	String customer_id;
	
	
	
	public Members(String username, String email, String mobile_number, String pswd, String user_type,
			String customer_id) {
		super();
		this.username = username;
		this.email = email;
		this.mobile_number = mobile_number;
		this.pswd = pswd;
		this.user_type = user_type;
		this.customer_id = customer_id;
	}
	
	public Members(String username, String email, String mobile_number, String customer_id) {
		super();
		this.username = username;
		this.email = email;
		this.mobile_number = mobile_number;
		this.customer_id = customer_id;
	}
	
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile_number() {
		return mobile_number;
	}
	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}
	public String getPswd() {
		return pswd;
	}
	public void setPswd(String pswd) {
		this.pswd = pswd;
	}
	public String getUser_type() {
		return user_type;
	}
	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
}