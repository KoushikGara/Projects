package com.BookBin.User;

import java.sql.*;
import java.util.*;

public class TransactionsDAO 
{
	   String url = "jdbc:mysql://localhost:3306/KOUSHIK";
	   String uname = "root";
	   String pass = "Gkoushik@7";
	
	   protected Connection getConnection() {
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
	
	
	   public String getBookID(String book_name) 
	   {
	      String book_id = null;
	      String book_title= book_name; 
	      try 
	      {
	             Connection con = this.getConnection(); 
	             PreparedStatement pst = con.prepareStatement("select book_id from books where book_title = ?");
	 
	             pst.setString(1, book_title);
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
	   
	   
	  
	 
	   
	   public int getRequestsNumber(String id)
	   {
		   int count  = 0;
		   String n = "r";
		   String owner_id = id;
		    try {
		            Connection con = this.getConnection();
		            PreparedStatement pst = con.prepareStatement("select count(trans_id) from transactions where trans_status = ? and owner_id = ?");
		            pst.setString(1, n);
		            pst.setString(2, owner_id);
		            
		            ResultSet rs = pst.executeQuery();
		            rs.next();
		            count =  rs.getInt(1);
		    }
		    catch(Exception e)
		    {
		    	e.printStackTrace();
		    }
		    
		    return count;
	   }

	   public int getPendingbooks(String id)
	   {
		   int count  = 0;
		   String n = "a";
		   String receiver_id = id;
		   int rd;
		    try {
		            Connection con = this.getConnection();
		            PreparedStatement pst = con.prepareStatement("select * from transactions where trans_status = ? and receiver_id = ?");
		            pst.setString(1, n);
		            pst.setString(2, receiver_id);
		            ResultSet rs = pst.executeQuery();
		            while(rs.next()) 
		            {
		            	rd = Integer.parseInt(rs.getString("remaining_days"));
		            	if(rd < 0)
		            		count = count + 1;
		            }
		    }
		    catch(Exception e)
		    {
		    	e.printStackTrace();
		    }
		    
		    return count;
	   }
	   
	   public int getTransactionsNumber()
	   {
		   int count  = 0;
		    try {
		            Connection con = this.getConnection();
		            PreparedStatement pst = con.prepareStatement("select count(trans_id) from transactions");
		            ResultSet rs = pst.executeQuery();
		            rs.next();
		            count =  rs.getInt(1);
		    }
		    catch(Exception e)
		    {
		    	e.printStackTrace();
		    }
		    
		    return count;
	   } 
	   
	 
	   public String getOwnerID(String id) 
	   {
	      String owner_id = null;
	      String book_id = id; 
	      try 
	      {
	             Connection con = this.getConnection(); 
	             PreparedStatement pst = con.prepareStatement("select customer_id from books where book_id = ?");
	 
	             pst.setString(1, book_id);
	             ResultSet rs = pst.executeQuery();
	             rs.next();
	             owner_id = rs.getString("customer_id");
	      }
	      catch(Exception e)
	      {
	    	  e.printStackTrace();
	      }
	          
	 
	      return owner_id;
	   }
	   
	   
	   
	   
	   
	   public String getBookPrice(String book_title) 
	   {
	      String book_price = null;
	      String book_name = book_title; 
	      try 
	      {
	             Connection con = this.getConnection(); 
	             PreparedStatement pst = con.prepareStatement("select book_price from books where book_title = ?");
	 
	             pst.setString(1, book_name);
	             ResultSet rs = pst.executeQuery();
	             rs.next();
	             book_price = rs.getString("book_price");
	      }
	      catch(Exception e)
	      {
	    	  e.printStackTrace();
	      }
	          
	 
	      return book_price;
	   }
	   
	   
	   
	   
	   
	  public String generateTransactionId()
	  {
		  int max = 1000;
	      int min = 1;
	      String TransactionID = null;
	 
	      while(true) 
	      {
	         int n = (int)(Math.random() * (double)(max - min + 1) + (double)min);
	         String numval = Integer.toString(n);
	         TransactionID = "BBTS" + numval;
	            
	         	try 
	        	{
	               Connection con = this.getConnection();
	               PreparedStatement pst = con.prepareStatement("select * from transactions where trans_id = ?");
	 
	               pst.setString(1, TransactionID);
	               ResultSet rs = pst.executeQuery();
	               
	               if(!rs.next())
	            	  return TransactionID ;
	        	}
	         	catch(Exception e)
	         	{
	        	e.printStackTrace();
	         	}
	      }           
	  }
	   
	  
	  public void setStatus( String trans_id,String trans_status,String receiver_id,String owner_id,String book_id,String book_title, String trans_amount,String remaining_days)
	  {
		  
	      
	      try 
	      {
	             Connection con = this.getConnection(); 
	             PreparedStatement pst = con.prepareStatement("insert into transactions(trans_id,trans_status,receiver_id,owner_id,book_id,book_title,trans_amount,remaining_days) values(?,?,?,?,?,?,?,?)");
	 
	             pst.setString(1, trans_id);
	             pst.setString(2, trans_status);
	             pst.setString(3, receiver_id);
	             pst.setString(4, owner_id);
	             pst.setString(5, book_id);
	             pst.setString(6, book_title);
	             pst.setString(7, trans_amount);
	             pst.setString(8,remaining_days);
	             
	             pst.executeUpdate();
			    
	             
	            
	      }
	      catch(Exception e)
	      {
	    	  e.printStackTrace();
	      }
	          
	 
	     
	  }
	  
	  
	  public List<Transactions> allUserTransactions()
	   {
	      ArrayList mytransactions = new ArrayList();       
	         try 
	         {
	            Connection con = this.getConnection();
	            PreparedStatement pst = con.prepareStatement("select * from transactions");
	           
	            ResultSet rs = pst.executeQuery();
	 
	            while(rs.next())
	            {
	                 String trans_id = rs.getString("trans_id");
	                 String trans_status = rs.getString("trans_status");
	                 String receiver_id = rs.getString("receiver_id");
	                 String owner_id = rs.getString("owner_id");
	                 String book_id = rs.getString("book_id");
	                 String book_title = rs.getString("book_title");
	                 String trans_amount = rs.getString("trans_amount");
	                 String issued_date = rs.getString("issued_date");
	                 String remaining_days = rs.getString("remaining_days");
	                 mytransactions.add(new Transactions(trans_id,trans_status,receiver_id,owner_id,book_id,book_title,trans_amount,issued_date,remaining_days));
	            }
	       } 
	      catch(Exception e)
	         {
	    	  	e.printStackTrace();
	         }
	 
	      return mytransactions;
	   }
	  
	  
	  public void imposePenalty(String tid)
	  {
		  String trans_id = tid;
		  try 
	      {
			Connection con = this.getConnection();
	 		PreparedStatement pst = con.prepareStatement("select receiver_id,trans_amount,remaining_days from transactions where trans_id = ?");
	        pst.setString(1, trans_id);	       
			ResultSet rs = pst.executeQuery();
			rs.next();
			String rid = rs.getString("receiver_id");
			String tm = rs.getString("trans_amount");
			String rd = rs.getString("remaining_days");
			int transamt = Integer.parseInt(tm);
			int remdays = Integer.parseInt(rd);
			
			pst = con.prepareStatement("select  wallet_money from customers where customer_id = ?");
			pst.setString(1, rid);	
			rs = pst.executeQuery();
			rs.next();
			 
			String wm = rs.getString("wallet_money");
			int wamt = Integer.parseInt(wm);
			
			wamt =  wamt + remdays * 10;
			transamt = transamt - remdays * 10;
			
			String w_money = Integer.toString(wamt);
			
			pst = con.prepareStatement("update customers set wallet_money = ? where customer_id = ?");
			pst.setString(1, w_money );
			pst.setString(2, rid);
			pst.executeUpdate();
			
			
			String t_money = Integer.toString(transamt );
			pst = con.prepareStatement("update transactions set trans_amount = ?, remaining_days = ? where trans_id = ?");
			pst.setString(1, t_money );
			pst.setString(2, "0");
			pst.setString(3, trans_id);
			pst.executeUpdate();
			
			
	      } 
	      
	      catch (Exception e) 
	      {
	         e.printStackTrace();
	      } 
	      
	  }
	  
	 
}
