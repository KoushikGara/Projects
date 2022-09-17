package com.BookBin.User;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/RequestExtension")
public class RequestExtension extends HttpServlet {
	private static final long serialVersionUID = 1L;

    String userId;
    RequestDispatcher dispatcher = null;
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
		         requestExtension(request, response);
		      } 
		      catch (IOException | SQLException | ServletException e)
		      {
		         e.printStackTrace();
		      }
		
	}
	

	   private void requestExtension(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException 
	   {
	      String book_id = request.getParameter("borrowed-book-id-2");
	      System.out.println("RequestExtension" + book_id);
	      mybookdao.requestExtension(book_id);
	      response.sendRedirect("Books");
	   }

}
