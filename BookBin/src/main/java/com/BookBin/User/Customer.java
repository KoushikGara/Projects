package com.BookBin.User;
 
public class Customer 
{
	private String username;
	private String email;
	private String mobile_number;
	private String pswd;
	private String user_type;
	private String wallet_money;
	
	private String customer_id;
	
	
	
	
	
	public Customer(String username, String email, String mobile_number, String pswd, String user_type,String wallet_money,
			String customer_id) {
		super();
		this.username = username;
		this.email = email;
		this.mobile_number = mobile_number;
		this.pswd = pswd;
		this.user_type = user_type;
		this.wallet_money = wallet_money;
		this.customer_id = customer_id;
	}
	
	
	public Customer(String username, String email, String mobile_number, String wallet_money, String customer_id) {
		super();
		this.username = username;
		this.email = email;
		this.mobile_number = mobile_number;
		this.wallet_money = wallet_money;
		this.customer_id = customer_id;
	}
	
	public Customer(String username, String email, String mobile_number,String customer_id) {
		super();
		this.username = username;
		this.email = email;
		this.mobile_number = mobile_number;
		this.customer_id = customer_id;
	}
	
	
	
	
	
	
	
	
	
	
	public String getWallet_money() {
		return wallet_money;
	}


	public void setWallet_money(String wallet_money) {
		this.wallet_money = wallet_money;
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