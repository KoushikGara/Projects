package com.BookBin.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/AdminBooks")
public class AdminBooks extends HttpServlet {
	private static final long serialVersionUID = 1L;
	   
	   RequestDispatcher dispatcher = null;
	   private MyBookDAO mybookdao;
	   private MembersDAO membersdao;
	   private TransactionsDAO transactionsdao;
	   
	   public void init() {
		      this.mybookdao = new MyBookDAO();
		      this.membersdao = new MembersDAO();
		      this.transactionsdao = new TransactionsDAO();
		      
		   }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try 
		{
			int users = membersdao.getUsersNumber();
			int alltransactions = transactionsdao.getTransactionsNumber();
			int bookscount = mybookdao.getBooksNumber();
			
			String userscount = Integer.toString(users);
			String transactionscount = Integer.toString(alltransactions);
			String booksnum = Integer.toString(bookscount);
			
			request.setAttribute("userscount", userscount);
			request.setAttribute("transactionscount", transactionscount);
			request.setAttribute("bookscount", booksnum);
			
			listAllBooks(request, response);
		} 
		catch (ServletException | IOException | SQLException e) 
		{
						e.printStackTrace();
		}
	}
	
	
	 private void listAllBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		   
		  List<MyBook> listAllBook = mybookdao.allBooks();
	      request.setAttribute("listAllBook", listAllBook);
	      dispatcher = request.getRequestDispatcher("Admin.jsp");
	      dispatcher.forward(request, response);
	      
	   }
}
