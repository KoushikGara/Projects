package com.BookBin.User;
 
import java.sql.*;
import java.util.*;
 
public class MembersDAO {
   String url = "jdbc:mysql://localhost:3306/KOUSHIK";
   String uname = "root";
   String pass = "Gkoushik@7";
   private static final String SELECT_USER = "select *  from customers where user_type = 'Customer'";
   private static final String SELECT_ADMIN = "select *  from customers where user_type = 'Admin'";
   private static final String DELETE_USERS_SQL = "delete from customers where customer_id = ?";
 
   protected Connection getConnection() {
      Connection con = null;
 
      try {
         Class.forName("com.mysql.cj.jdbc.Driver");
         con = DriverManager.getConnection(this.url, this.uname, this.pass);
      } 
      catch (Exception e) 
      {
         e.printStackTrace();
      } 
 
      return con;
   }
 
   public List<Customer> selectAllUsers() 
   {
      ArrayList customers = new ArrayList();
 
	    try {
	            Connection con = this.getConnection();
	            PreparedStatement pst = con.prepareStatement(SELECT_USER);
	            ResultSet rs = pst.executeQuery();
	 
	            while(rs.next()) 
	            {
	                     String username = rs.getString("username");
	                     String email = rs.getString("email");
	                     String mobile_number = rs.getString("mobile_number");
	                     String wallet_money = rs.getString("wallet_money");
	                     String customer_id = rs.getString("customer_id");
	                    
	                     
	                     customers.add(new Customer(username, email, mobile_number, wallet_money,customer_id));
	                  
	            }
	               
	    	} 
	    catch(Exception e)
		{
			e.printStackTrace();
		}
 
      return customers;
   }
   
   public int getUsersNumber()
   {
	   int count  = 0;
	    try {
	            Connection con = this.getConnection();
	            PreparedStatement pst = con.prepareStatement("select count(customer_id) from customers");
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
   
   
   
   
   
   
   
   
   
   
   
   
   public List<Customer> selectAllAdmins() 
   {
      ArrayList customers = new ArrayList();
 
	    try {
	            Connection con = this.getConnection();
	            PreparedStatement pst = con.prepareStatement(SELECT_ADMIN);
	            ResultSet rs = pst.executeQuery();
	 
	            while(rs.next()) 
	            {
	                     String username = rs.getString("username");
	                     String email = rs.getString("email");
	                     String mobile_number = rs.getString("mobile_number");
	                     String customer_id = rs.getString("customer_id");
	                     
	                     System.out.println(username);
	                     System.out.println(email);
	                     System.out.println(mobile_number);
	                     System.out.println(customer_id);
	                     customers.add(new Customer(username, email, mobile_number, customer_id));
	                  
	            }
	               
	    	} 
	    catch(Exception e)
		{
			e.printStackTrace();
		}
 
      return customers;
   }
   
 
   public void deleteUser(String id) throws SQLException {
     try {
            Connection con = this.getConnection();
            PreparedStatement pst = con.prepareStatement("SET FOREIGN_KEY_CHECKS = 0");
            pst.executeUpdate();
            
            pst = con.prepareStatement("delete from customers where customer_id = ?");
            pst.setString(1, id);
            pst.executeUpdate();
            
            pst = con.prepareStatement("SET FOREIGN_KEY_CHECKS = 1");
            pst.executeUpdate();
            
         } 
     catch(Exception e)
     {
    	 e.printStackTrace();
     }
 
   }
}