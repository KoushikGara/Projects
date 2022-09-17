package com.BookBin.User;
 
import java.sql.*;
import java.util.*;
 
public class MyBookDAO {
   String url = "jdbc:mysql://localhost:3306/KOUSHIK";
   String uname = "root";
   String pass = "Gkoushik@7";
   private static final String SELECT_BOOK_BY_NAME = "select * from books where book_publisher = ?";
   private static final String DELETE_BOOK_BY_ID = "delete from books where book_id = ?";
   private static final String SELECT_BORROWED_BOOK = "select * from books where customer_id = ? and book_publisher <> ? ";
   private static final String GET_USER_BY_ID = "select username from customers where customer_id = ?";
   private static final String INSERT_BOOK = "insert into books(book_id,book_status,book_title,book_author,book_publisher,book_edition,book_price,book_description,published_year,customer_id) values(?,?,?,?,?,?,?,?,?,?)";
   private static final String CHECK_ID = "select * from books where book_id = ?";
 
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
 
   
   
   
   public String getUserName(String user_id) 
	   {
	      String name = null;
	      String u_id = user_id; 
	      try 
	      {
	             Connection con = this.getConnection(); 
	             PreparedStatement pst = con.prepareStatement("select username from customers where customer_id = ?");
	 
	             pst.setString(1, u_id);
	             ResultSet rs = pst.executeQuery();
	             rs.next();
	             name = rs.getString("username");
	             System.out.println(name);
	      }
	      catch(Exception e)
	      {
	    	  e.printStackTrace();
	      }
	          
	 
	      return name;
	   }
   
   
   
   
   public int getBooksNumber()
   {
	   int count  = 0;
	    try {
	            Connection con = this.getConnection();
	            PreparedStatement pst = con.prepareStatement("select count(book_id) from books");
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
   
   
   
   public String generateBookId() 
   {
      int max = 1000;
      int min = 1;
      String BookID = null;
 
      while(true) 
      {
         int n = (int)(Math.random() * (double)(max - min + 1) + (double)min);
         String numval = Integer.toString(n);
         BookID = "BB" + numval;
            
         	try 
        	{
               Connection con = this.getConnection();
               PreparedStatement pst = con.prepareStatement("select * from books where book_id = ?");
 
               pst.setString(1, BookID);
               ResultSet rs = pst.executeQuery();
               
               if(!rs.next())
            	  return BookID ;
        	}
         	catch(Exception e)
         	{
        	e.printStackTrace();
         	}
      }            
    }
   
   
   
   
   public List<MyBook> allBooks()
   {
      ArrayList mybooks = new ArrayList();       
         try 
         {
            Connection con = this.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from books");
           
            ResultSet rs = pst.executeQuery();
 
            while(rs.next())
            {
                 String book_id = rs.getString("book_id");
                 String book_status = rs.getString("book_status");
                 String book_title = rs.getString("book_title");
                 String book_author = rs.getString("book_author");
                 String book_price = rs.getString("book_price");
                 String customer_id = rs.getString("customer_id");
                 String book_edition = rs.getString("book_edition");
                 String book_description = rs.getString("book_description");
                 String book_publisher = rs.getString("book_publisher");
                 String published_year = rs.getString("published_year");
                 mybooks.add(new MyBook(book_id, book_status, book_title, book_author, book_publisher, book_edition, book_price, book_description, published_year, customer_id));
            }
       } 
      catch(Exception e)
         {
    	  	e.printStackTrace();
         }
 
      return mybooks;
   }
   
   
   
   
 
   public List<MyBook> allPublishedBooks(String user_name)
   {
      ArrayList mybooks = new ArrayList();       
         try 
         {
            Connection con = this.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from books where book_publisher = ?");
            pst.setString(1, user_name);
            ResultSet rs = pst.executeQuery();
 
            while(rs.next())
            {
                 String book_id = rs.getString("book_id");
                 String book_status = rs.getString("book_status");
                 String book_title = rs.getString("book_title");
                 String book_author = rs.getString("book_author");
                 String book_price = rs.getString("book_price");
                 String customer_id = rs.getString("customer_id");
                 String book_edition = rs.getString("book_edition");
                 String book_description = rs.getString("book_description");
                 String book_publisher = rs.getString("book_publisher");
                 String published_year = rs.getString("published_year");
                 mybooks.add(new MyBook(book_id, book_status, book_title, book_author, book_publisher, book_edition, book_price, book_description, published_year, customer_id));
            }
       } 
      catch(Exception e)
         {
    	  	e.printStackTrace();
         }
 
      return mybooks;
   }
 
   public void deletePublishedBook(String book_id) throws SQLException {
     
         try 
         {
        	 	Connection con = this.getConnection();
        	 	PreparedStatement pst = con.prepareStatement("delete from books where book_id = ?");
        	 	pst.setString(1, book_id);
                  pst.executeUpdate();
         } 
         catch(Exception e)
         {
        	 e.printStackTrace();
         }
 
   }
 
   public List<MyBook> allBorrowedBooks(String user_name, String cust_id) 
   {
      ArrayList mybooks = new ArrayList();
 
         try 
         {
            Connection con = this.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from books where customer_id = ? and book_publisher <> ? ");
 
            String customer_id = cust_id;
            pst.setString(1, cust_id);
            pst.setString(2, user_name);
            ResultSet rs = pst.executeQuery();
 
            while(rs.next()) 
            {
                     String book_id = rs.getString("book_id");
                     String book_title = rs.getString("book_title");
                     String book_author = rs.getString("book_author");
                     String book_price = rs.getString("book_price");
                     mybooks.add(new MyBook(book_id, book_title, book_author, book_price, customer_id));
             }
         }
         catch(Exception e)
         {
        	 e.printStackTrace();
         }
 
      return mybooks;
   }
 
  
 
   public void addBook(MyBook mybook) throws SQLException 
   {
     
         try 
         {
            Connection con = this.getConnection();
            PreparedStatement pst = con.prepareStatement("insert into books(book_id,book_status,book_title,book_author,book_publisher,book_edition,book_price,book_description,published_year,customer_id) values(?,?,?,?,?,?,?,?,?,?)");
 
	           pst.setString(1, mybook.book_id);
	           pst.setString(2, mybook.book_status);
	           pst.setString(3, mybook.book_title);
	           pst.setString(4, mybook.book_author);
	           pst.setString(5, mybook.book_publisher);
	           pst.setString(6, mybook.book_edition);
	           pst.setString(7, mybook.book_price);
	           pst.setString(8, mybook.book_description);
	           pst.setString(9, mybook.published_year);
	           pst.setString(10, mybook.customer_id);
	           pst.executeUpdate();
         }
           catch(Exception e)
   		{
   			e.printStackTrace();
   		}
         
         
 
   }
   
   
   
   
   public List<Transactions> allRequests(String user_id)
	  {
		  ArrayList requests = new ArrayList();  
		  String owner_id = user_id;
		  try 
	         {
	            Connection con = this.getConnection();
	            PreparedStatement pst = con.prepareStatement("select * from transactions where owner_id = ? and trans_status = ?");
	            pst.setString(1, owner_id);
	            pst.setString(2, "r");
	            ResultSet rs = pst.executeQuery();
	 
	            while(rs.next())
		        {	String trans_id = rs.getString("trans_id");
		        	String trans_status = rs.getString("trans_status");
		        	String receiver_id = rs.getString("receiver_id");
		        	   
		        	String book_id = rs.getString("book_id");
		        	String book_title = rs.getString("book_title");
		        	String trans_amount = rs.getString("trans_amount");
		        	String remaining_days = rs.getString("remaining_days");
	                requests.add(new Transactions(trans_id,trans_status,receiver_id,book_id,book_title,trans_amount,remaining_days));
	                System.out.println(trans_status+ " "+book_id);
	            }
	       } 
	      catch(Exception e)
	         {
	    	  	e.printStackTrace();
	         }
	 
	      return requests;
	  }
   
   
   	public void requestExtension(String bid)
   	{
   		String book_id =bid;
   		int days = 0;
   		try 
        {
       	 	Connection con = this.getConnection();
       	 	PreparedStatement pst = con.prepareStatement("select remaining_days from transactions where book_id = ?");
       	 	pst.setString(1, book_id);
       	    ResultSet rs =  pst.executeQuery();
       	    rs.next();
       	    String rd = rs.getString("remaining_days");
       	    days = Integer.parseInt(rd);
       	    System.out.println("from db: "+rd);
       	    System.out.println(days);
            days = days + 15;     
            pst = con.prepareStatement("update  transactions set remaining_days = ? where book_id = ?");
            String remaining_days = Integer.toString(days);
            pst.setString(1, remaining_days);
            pst.setString(2, book_id);
            pst.executeUpdate();
        } 
        catch(Exception e)
        {
       	 e.printStackTrace();
        }
   	}
   
   
   	public void returnBook(String bid, String uid)
   	{
   		String book_id =bid;
   		String customer_id = uid;
   		
   		try 
        {
       	 	Connection con = this.getConnection();
       	 	PreparedStatement pst = con.prepareStatement("select wallet_money from customers where customer_id = ? ");
       	 	pst.setString(1, customer_id);
       	 	ResultSet rs = pst.executeQuery();
       	 	rs.next();
       	 	String wm = rs.getString("wallet_money");
       	 	pst = con.prepareStatement("select trans_amount from transactions where book_id = ? and trans_status = ?");
       		pst.setString(1, book_id);
       		pst.setString(2, "a");
       		rs = pst.executeQuery();
       	 	rs.next();
       	 	String tm = rs.getString("trans_amount");
       	 	
       	 	int wam = Integer.parseInt(wm) - Integer.parseInt(tm);
       	 	String new_wm = Integer.toString(wam);
       	 	
       	 	pst = con.prepareStatement("update  customers set wallet_money = ? where customer_id = ?");
       	 	pst.setString(1, new_wm);       	 	
       	 	pst.setString(2, customer_id);
       	 	pst.executeUpdate();
       	 	
       	 	
       	 	pst = con.prepareStatement("update  transactions set trans_status = ? where book_id = ? and trans_status = ?");
    	 	pst.setString(1, "c");       	 	
    	 	pst.setString(2, book_id);
    	 	pst.setString(3, "a");
    	 	pst.executeUpdate();
       	 
    	 	
    	 	pst = con.prepareStatement("select book_publisher from books where book_id = ?");
       		pst.setString(1, book_id);
       		rs = pst.executeQuery();
       	 	rs.next();
       	 	String owner_name = rs.getString("book_publisher");
       	 	
       	 	pst = con.prepareStatement("select customer_id from customers where username = ?");
    		pst.setString(1, owner_name);
    		rs = pst.executeQuery();
    	 	rs.next();
    	 	String owner_id = rs.getString("customer_id");
       	 	
    	 	
    	 	pst = con.prepareStatement("update  books set book_status = ?, customer_id = ? where book_id = ?");
    	 	pst.setString(1, "active");
    	 	pst.setString(2, owner_id);
    	 	pst.setString(3, book_id);
    	 	pst.executeUpdate();
    	 	
    	 	
    	 	
    	 	pst = con.prepareStatement("select wallet_money from customers where customer_id = ? ");
       	 	pst.setString(1, owner_id);
       	 	rs = pst.executeQuery();
       	 	rs.next();
       	    String nwm = rs.getString("wallet_money");
       	    int amount = Integer.parseInt(nwm) + Integer.parseInt(tm);
       	    String nowm = Integer.toString(amount);
    	 	
    	 	
	       	pst = con.prepareStatement("update  customers set wallet_money = ? where customer_id = ?");
	 	 	pst.setString(1, nowm);
	 	 	pst.setString(2, owner_id);
	 	 	pst.executeUpdate();
 	 	
    	 	
    	 	
    	 	
    	 	
        } 
        catch(Exception e)
        {
       	 e.printStackTrace();
        }
   	}
   
   
   
   public void withdrawAccount(String id)
   {
	   String customer_id = id;
	   try 
       {
      	 	Connection con = this.getConnection();
      	    PreparedStatement pst = con.prepareStatement("SET FOREIGN_KEY_CHECKS = 0");
            pst.executeUpdate();
          
          
      	 	pst = con.prepareStatement("delete from customers where customer_id = ? ");
      	 	pst.setString(1, customer_id);
      	 	pst.executeUpdate();
      	 	
      	  pst = con.prepareStatement("SET FOREIGN_KEY_CHECKS = 1");
          pst.executeUpdate();
      	 	
       } 
       catch(Exception e)
       {
      	 e.printStackTrace();
       }
   }




public String getStatus(String book_name) {
	String book_status = null;
	try 
    {
	   	 Connection con = this.getConnection();
	   	 PreparedStatement pst = con.prepareStatement("select book_status from books where book_title = ?");
	   	 pst.setString(1, book_name);
	   	 ResultSet rs = pst.executeQuery();
	   	 rs.next();
	   	 book_status = rs.getString("book_status");
	   	 System.out.println("441: "+book_status);
    } 
    catch(Exception e)
    {
   	 e.printStackTrace();
    }
	return book_status;
}
   
   
   
   
   
   
   
   
   
}