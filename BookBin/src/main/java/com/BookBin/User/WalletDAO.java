package com.BookBin.User;

import java.io.IOException;

import java.sql.*;
import java.util.*;

import java.time.LocalDate;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class WalletDAO 
{
	   String url = "jdbc:mysql://localhost:3306/KOUSHIK";
	   String uname = "root";
	   String pass = "Gkoushik@7";
	   
	   protected Connection getConnection() 
	   {
		      Connection con = null;
		 
		      try 
		      {
		         Class.forName("com.mysql.cj.jdbc.Driver");
		         con = DriverManager.getConnection(this.url, this.uname, this.pass);
		      } 
		      
		      catch (SQLException e) 
		      {
		         e.printStackTrace();
		      } 
		      
		      catch (ClassNotFoundException e) 
		      {
		         e.printStackTrace();
		      }
		 
		      return con;
		   }
	   
	   //getWalletMoney
	   
	   public String getWalletMoney(String user_id)
	   {
		   String customer_id = user_id;
		   String wallet_Money = null;
		   try 
		      {
				Connection con = this.getConnection();
		 		PreparedStatement pst = con.prepareStatement("select wallet_money from customers where customer_id = ?");
		        pst.setString(1, customer_id);
		       
				ResultSet rs = pst.executeQuery();
				rs.next();
				wallet_Money = rs.getString("wallet_money");
				
				
		      }
		   catch (Exception e) 
		      {
		         e.printStackTrace();
		      } 
		   return wallet_Money;
	   }
	   
	   //addMoney
	   
	   public void addMoney(String userId, String new_money)
		{	
			String customer_id = userId;
			String w_money = null;
			
			try 
		      {
				Connection con = this.getConnection();
		 		PreparedStatement pst = con.prepareStatement("select wallet_money from customers where customer_id = ?");
		        pst.setString(1, customer_id);
		       
				ResultSet rs = pst.executeQuery();
				rs.next();
				w_money = rs.getString("wallet_money");
				int wm = Integer.parseInt(w_money);
				int nm = Integer.parseInt(new_money);
				wm = wm + nm;
				w_money = Integer.toString(wm);
				pst = con.prepareStatement("update customers set wallet_money = ? where customer_id = ?");
				pst.setString(1, w_money);
				pst.setString(2, customer_id);
				pst.executeUpdate();
				
		      } 
		      
		      catch (Exception e) 
		      {
		         e.printStackTrace();
		      } 
		      
//			
		}
	   
	   
	   //rejectRequest
	   public void rejectRequest(String id)
	   {
		   	String trans_id = id;
			String trans_status = "c";
			String trans_amount ="0";
			
			try 
		      {
				Connection con = this.getConnection();
		 		PreparedStatement pst = con.prepareStatement("update transactions set trans_status = ?, trans_amount = ? where trans_id = ?");
		        pst.setString(1, trans_status);
		        pst.setString(2, trans_amount);
		        pst.setString(3, trans_id);
		       
				
				pst.executeUpdate();
				
		      } 
		      
		      catch (Exception e) 
		      {
		         e.printStackTrace();
		      } 
	   }
	   
	   public String getBookID(String tid) 
	   {
	      String book_id = null;
	      String trans_id= tid;
	      try 
	      {
	             Connection con = this.getConnection(); 
	             PreparedStatement pst = con.prepareStatement("select book_id from transactions where trans_id = ?");
	 
	             pst.setString(1, trans_id);
	             ResultSet rs = pst.executeQuery();
	             rs.next();
	             book_id = rs.getString("book_id");
	      }
	      catch(Exception e)
	      {
	    	  e.printStackTrace();
	      }
	          
	 
	      return book_id;
	   }
	   
	   
	   
	   public String getReceiverId(String tid) 
	   {
	      String receiver_id = null;
	      String trans_id= tid;
	      try 
	      {
	             Connection con = this.getConnection(); 
	             PreparedStatement pst = con.prepareStatement("select receiver_id from transactions where trans_id = ?");
	 
	             pst.setString(1, trans_id);
	             ResultSet rs = pst.executeQuery();
	             rs.next();
	             receiver_id = rs.getString("receiver_id");
	      }
	      catch(Exception e)
	      {
	    	  e.printStackTrace();
	      }
	          
	 
	      return receiver_id;
	   }
	   
	   
	   
	   
	   
	   
	   
	   //acceptRequest
	   public void acceptRequest(String tid, String rid, String bid)
	   {
		   	String trans_id = tid;
		   	String receiver_id = rid;
		   	String book_id = bid;
			String trans_status = "a";
			java.util.Date date = new java.util.Date();
			java.sql.Date  sqldate =  new java.sql.Date(date.getTime());
			
			
			
			try 
		      {
				Connection con = this.getConnection();
		 		PreparedStatement pst = con.prepareStatement("update transactions set trans_status = ?, issued_date = ? where trans_id = ?");
		        pst.setString(1, trans_status);
		        pst.setDate(2,sqldate);
		        pst.setString(3, trans_id);
		       
				
				pst.executeUpdate();
				
				pst = con.prepareStatement("update books set book_status = ?, customer_id = ? where book_id = ?");
				pst.setString(1, "inactive");
				pst.setString(2, receiver_id);
				pst.setString(3, book_id);
				
				pst.executeUpdate();
				
		      } 
		      
		      catch (Exception e) 
		      {
		         e.printStackTrace();
		      } 
	   }
	   
	   
	   //All Transactions
	   
	   public List<Transactions> allTransactions(String id)
	   {
	   	  String receiver_id = id;
	      ArrayList mytransactions = new ArrayList();       
	         try 
	         {
	            Connection con = this.getConnection();
	            PreparedStatement pst = con.prepareStatement("select * from transactions where receiver_id = ? or owner_id = ?");
	            pst.setString(1, receiver_id);
	            pst.setString(2, receiver_id);
	            ResultSet rs = pst.executeQuery();
	 
	            while(rs.next())
	            {
	                 String trans_id = rs.getString("trans_id");
	                 String trans_status = rs.getString("trans_status");
	                
	                 String owner_id = rs.getString("owner_id");
	                 String book_id = rs.getString("book_id");
	                 String book_title = rs.getString("book_title");
	                 String trans_amount = rs.getString("trans_amount");
	                 String issued_date = rs.getString("issued_date");
	                 String remaining_days = rs.getString("remaining_days");
	                 System.out.println(trans_status+" "+book_title+" "+trans_amount);
	                 mytransactions.add(new Transactions(trans_id, trans_status, receiver_id, owner_id, book_id,  book_title, trans_amount, issued_date, remaining_days));
	            }
	       } 
	      catch(Exception e)
	         {
	    	  	e.printStackTrace();
	         }
	 
	      return mytransactions;
	   }
	 
	   
}
