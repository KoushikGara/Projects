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


@WebServlet("/ImposePenality")
public class ImposePenality extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String userId;
	   RequestDispatcher dispatcher = null;
	  
	   private TransactionsDAO transactionsdao;
	   
	   public void init() {
		     
		      this.transactionsdao = new TransactionsDAO();
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
	   		this.dispatcher = request.getRequestDispatcher("Books.jsp");
 
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
	   		
    	  	  imposePenality(request,response);
        } 
       catch (Exception e) 
       {
         e.printStackTrace();
       }
	   	
		
	}
	
	private void imposePenality(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String tid = request.getParameter("tid");
		transactionsdao.imposePenalty(tid);
		dispatcher = request.getRequestDispatcher("TransactionServlet");
		dispatcher.forward(request, response);
	}
}
