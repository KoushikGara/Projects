package com.BookBin.User;

import java.io.IOException;

import java.sql.*;
import java.util.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Wallet")
public class Wallet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 String userId;
	   RequestDispatcher dispatcher = null;
	   HttpSession session  = null;
   private WalletDAO walletdao;
   private MyBookDAO mybookdao;
   
   public void init()
   {
	   walletdao = new WalletDAO();
	   mybookdao = new MyBookDAO();
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
	   		
	   		String username = mybookdao.getUserName(userId);
	   		request.setAttribute("username", username);
	   		String new_money = request.getParameter("wallet-money");
	   		addMoney(request,response,userId,new_money);
	   		listAllTransactions(request,response,userId);
	   	}
	   	catch(Exception e){
	   		e.printStackTrace();
	   	}
	   	
	  
	}
	
	private void addMoney(HttpServletRequest request, HttpServletResponse response,String userId,String new_money)throws ServletException, IOException
	{	
		 walletdao.addMoney(userId, new_money);
		 dispatcher = request.getRequestDispatcher("Wallet.jsp");
			
		 
	}
	
	private void listAllTransactions(HttpServletRequest request, HttpServletResponse response, String user_id) throws ServletException, IOException, SQLException {
		   
		  List<Transactions> listTransactions = walletdao.allTransactions(user_id);
	      request.setAttribute("listTransactions", listTransactions);
	      String walletMoney = walletdao.getWalletMoney(user_id);
	      //session = request.getSession();
	      request.setAttribute("walletMoney", walletMoney);
	      dispatcher = request.getRequestDispatcher("Wallet.jsp");
		  dispatcher.forward(request, response);
	      
	   }
	
	
}
