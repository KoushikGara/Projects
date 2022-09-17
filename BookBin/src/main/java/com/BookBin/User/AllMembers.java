package com.BookBin.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/AllMembers")
public class AllMembers extends HttpServlet {
	private static final long serialVersionUID = 1L;

		String userId;
	   RequestDispatcher dispatcher = null;
	   private MembersDAO membersdao;
	   
	   public void init() {
		      this.membersdao = new MembersDAO();
		   }

	   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   Cookie[] cookies = request.getCookies();
		   if (cookies == null) 
		   {
	         response.sendRedirect("User.jsp");
		   } 
		   else 
		   {
	         this.dispatcher = request.getRequestDispatcher("Members.jsp");
	 
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
	         
	         listAllMembers(request, response);
	         listAllAdmins(request,response);
	        
	      } 
	      catch (IOException | SQLException | ServletException e) 
	      {
	         e.printStackTrace();
	      }
	 
	   }
	   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	   
	   private void listAllMembers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException
		{
		    List<Customer> listCustomer = membersdao.selectAllUsers();
			request.setAttribute("listCustomer", listCustomer);
			RequestDispatcher dispatcher = request.getRequestDispatcher("Members.jsp");
		}
	   
	   private void listAllAdmins(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException
		{
		    List<Customer> listAdmin = membersdao.selectAllAdmins();
			request.setAttribute("listAdmin", listAdmin);
			RequestDispatcher dispatcher = request.getRequestDispatcher("Members.jsp");
			dispatcher.forward(request, response);
		}

}
