package com.BookBin.User;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/RejectRequest")
public class RejectRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 String userId;
	   RequestDispatcher dispatcher = null;
  private WalletDAO walletdao;
  
  public void init()
  {
	   walletdao = new WalletDAO();
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
	   		this.dispatcher = request.getRequestDispatcher("Wallet.jsp");
 
	   		for(Cookie c: cookies)
	   		{
	   			String tname = c.getName();
	   			if (tname.equals("user_id")) 
	   			{
	   				userId = c.getValue();
	   				
	   			}
	   		}
	   	}
	   	
	   	try {
	   		rejectRequest(request,response);
	   	}
	   	catch(Exception e){
	   		e.printStackTrace();
	   	}
	   	
	}

	
	private void rejectRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
	{
		String tid = request.getParameter("transaction_id");
		
		walletdao.rejectRequest(tid);
		dispatcher = request.getRequestDispatcher("Books");
		dispatcher.forward(request, response);
	 
	}
}
