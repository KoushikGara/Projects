package com.BookBin.User;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String userId;
	private MyBookDAO mybookdao;
	private MembersDAO membersdao;
	private TransactionsDAO transactionsdao;
	RequestDispatcher dispatcher = null;
	HttpSession session  =null;
	
	public void init() 
	{
		mybookdao = new MyBookDAO();
		membersdao = new MembersDAO();
		transactionsdao = new TransactionsDAO();
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
		   	System.out.println(userId);
		   String username = mybookdao.getUserName(userId);
		   int usercount  = membersdao.getUsersNumber();
		   int bookscount = mybookdao.getBooksNumber();
		   int transcount = transactionsdao.getRequestsNumber(userId);
		   
		   String users = Integer.toString(usercount);
		   String booksnum = Integer.toString(bookscount);
		   String transnum = Integer.toString(transcount);
		   
		   System.out.println("customerservelt : " + username);
		   //session = request.getSession();
		   
		   request.setAttribute("userscount", users);
		   request.setAttribute("bookscount", booksnum);
		   request.setAttribute("transcount", transnum);
		   request.setAttribute("username", username);
		   
		   dispatcher = request.getRequestDispatcher("Customer.jsp");
		   dispatcher.forward(request, response);
		
	}

}
