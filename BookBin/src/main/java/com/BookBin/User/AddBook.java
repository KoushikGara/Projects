package com.BookBin.User;
 
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
 
@WebServlet({"/AddBook"})
public class AddBook extends HttpServlet {
   private static final long serialVersionUID = 1L;
   String userId;
   RequestDispatcher dispatcher = null;
   private MyBookDAO mybookdao;
 
   public void init() {
      this.mybookdao = new MyBookDAO();
   }
 
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      this.doPost(request, response);
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
         String bid = mybookdao.generateBookId();
         String name = mybookdao.getUserName(userId);
         addBook(request, response, name, userId, bid);
       } 
      catch(Exception e)
      {
    	  e.printStackTrace();
      }
 
   }
 
   private void addBook(HttpServletRequest request, HttpServletResponse response, String u_name, String cust_id, String bid) throws ServletException, IOException, SQLException {
      String book_title = request.getParameter("book-name");
      String book_author = request.getParameter("book-author");
      String book_edition = request.getParameter("book-edition");
      String bp = request.getParameter("book-price");
      String book_price = "$" + bp;
      String book_description = request.getParameter("book-desc");
      String published_year = request.getParameter("book-year");
      MyBook newbook = new MyBook(bid, "active", book_title, book_author, u_name, book_edition, book_price, book_description, published_year, cust_id);
      mybookdao.addBook(newbook);
      response.sendRedirect("Books");
   }
}