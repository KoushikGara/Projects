package com.BookBin.User;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ReturnBook")
public class ReturnBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String userId;
	private MyBookDAO mybookdao;
	  
    public void init() {
    System.out.println("Hello");
       this.mybookdao = new MyBookDAO();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		 Cookie[] cookies = request.getCookies();
		   if (cookies == null) 
		   {
	        response.sendRedirect("User.jsp");
		   } 
		   else 
		   {
	      
	
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
		         returnBook(request, response,userId);
		      } 
		      catch (IOException | SQLException | ServletException e)
		      {
		         e.printStackTrace();
		      }
		   
	}
	
	
	 private void returnBook(HttpServletRequest request, HttpServletResponse response, String id) throws ServletException, IOException, SQLException 
	   {
	      String book_id = request.getParameter("borrowed-book-id-1");
	      System.out.println("RequestExtension" + book_id);
	      mybookdao.returnBook(book_id,id);
	      response.sendRedirect("Books");
	   }

}
