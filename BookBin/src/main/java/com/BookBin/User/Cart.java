package com.BookBin.User;
 
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
 
@WebServlet({"/Cart"})
public class Cart extends HttpServlet {
   private static final long serialVersionUID = 1L;
   String userId;
   RequestDispatcher dispatcher = null;
   private TransactionsDAO transactionsdao;
   private MyBookDAO mybookdao;
   
   public void init() 
   {
	      this.transactionsdao = new TransactionsDAO();
	      this.mybookdao = new MyBookDAO();
	   
   }
   
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      this.doPost(request, response);
   }
 
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
   {
	      PrintWriter out = response.getWriter();
	    
	      Cookie[] cookies = request.getCookies();
		   if (cookies == null) 
		   {
	        response.sendRedirect("User.jsp");
		   } 
		   else 
		   {
	       // dispatcher = request.getRequestDispatcher("Books.jsp");
	
	         for(Cookie c: cookies)
	         {
	       	  	String tname = c.getName();
	       	  	if (tname.equals("user_id")) 
	          	 {
	              userId = c.getValue();
	            }
	         }
		   }
 
      try 
      {
    	  //receiverId
    	  String receiver_id = userId;
    	  String status_flag = null;
    	  
    	   
    	  
    	 //bookName 
         String book_name = request.getParameter("title-data"); 
                  
         
         //remaining days
         String remaining_days = request.getParameter("request-days");
        

         //Check whether the book is active
         String book_status = mybookdao.getStatus(book_name);
         if(book_status.equals("active"))
         {
	         
	         //bookId
	         String book_id = transactionsdao.getBookID(book_name);
	              
	        
	         //owner_Id
	         String owner_id = transactionsdao.getOwnerID(book_id);
	         
	         
	       
	        //bookprice
	         String book_price = transactionsdao.getBookPrice(book_name);
	                 
	         
	         //transaction status
	         String transID = transactionsdao.generateTransactionId();
	         transactionsdao.setStatus(transID,"r",receiver_id,owner_id,book_id,book_name, book_price,remaining_days);
	         status_flag = "true";
	         request.setAttribute("status_flag", status_flag);
	         
         }
         else
         {
        	 status_flag = "false";
        	 request.setAttribute("status_flag", status_flag);
         }
         
         System.out.println(status_flag);
         dispatcher = request.getRequestDispatcher("Books");
		 dispatcher.forward(request, response);
      } 
      catch (Exception e) 
      {
         e.printStackTrace();
      }
 
   }
}
    