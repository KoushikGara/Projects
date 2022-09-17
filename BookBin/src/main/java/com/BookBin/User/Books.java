 package com.BookBin.User;
 
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.*;
 
@WebServlet({"/Books"})
public class Books extends HttpServlet {
   private static final long serialVersionUID = 1L;
   String userId;
   String userName;
   RequestDispatcher dispatcher = null;
   private MyBookDAO mybookdao;
   private TransactionsDAO transactionsdao;
 
   public void init() {
      this.mybookdao = new MyBookDAO();
      this.transactionsdao = new TransactionsDAO();
   }
 
   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
   {
	   	Cookie[] cookies = request.getCookies();
	   	if (cookies == null) 
	   	{
         response.sendRedirect("User.jsp");
	   	} 
	   	else 
	   	{
	   		this.dispatcher = request.getRequestDispatcher("Books.jsp");
 
	   		for(Cookie c: cookies)
	   		{
	   			String tname = c.getName();
	   			if (tname.equals("user_id")) 
	   			{
	   				userId = c.getValue();
	   				
	   			}
	   			if (tname.equals("user_name"))
	   			{
	   				userName = c.getValue();
	   			}
	   		}
	   	}
 
	   	try 
	   	{
	   		
    	  String name = mybookdao.getUserName(userId);
    	  System.out.println("58: "+userName);
    	  
    	  request.setAttribute("username", userName);
    	  int booksPendingcount = transactionsdao.getPendingbooks(userId);
    	  String booksPending = Integer.toString(booksPendingcount);    	  
    	  request.setAttribute("booksPending",booksPending);
    	  listPublishedBooks(request, response, name);
    	  listBorrowedBooks(request, response, name, userId);
    	  listRequestedBooks(request,response,userId);
        } 
       catch (IOException | SQLException | ServletException e) 
       {
         e.printStackTrace();
       }
 
   }
 
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }
 
   private void listPublishedBooks(HttpServletRequest request, HttpServletResponse response, String user_name) throws ServletException, IOException, SQLException {
	   
	  List<MyBook> listPublishedBook = mybookdao.allPublishedBooks(user_name);
      request.setAttribute("listPublishedBook", listPublishedBook);
   }
 
   private void listBorrowedBooks(HttpServletRequest request, HttpServletResponse response, String user_name, String cust_id) throws ServletException, IOException, SQLException {
      List<MyBook> listBorrowedBook = mybookdao.allBorrowedBooks(user_name, cust_id);
      request.setAttribute("listBorrowedBook", listBorrowedBook);
    
     
   }
   
   private void listRequestedBooks(HttpServletRequest request, HttpServletResponse response, String user_id) throws ServletException, IOException {
	  List<Transactions> listRequestedBook = mybookdao.allRequests(user_id);
	  request.setAttribute("listRequestedBook", listRequestedBook);
	  dispatcher = request.getRequestDispatcher("Books.jsp");
      dispatcher.forward(request, response);
   }
  
}