package com.BookBin.User;
 
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
 
@WebServlet({"/DeleteBooks"})
public class DeleteBooks extends HttpServlet {
   private static final long serialVersionUID = 1L;
   RequestDispatcher dispatcher = null;
   private MyBookDAO mybookdao;
 
   public void init() {
      this.mybookdao = new MyBookDAO();
   }
 
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      this.dispatcher = request.getRequestDispatcher("Books.jsp");
 
      try 
      {
         this.deletePublishedBook(request, response);
      } 
      catch (IOException | SQLException | ServletException e)
      {
         e.printStackTrace();
      }
 
   }
 
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      this.doGet(request, response);
   }
 
   private void deletePublishedBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException 
   {
      String book_id = request.getParameter("published_book_id");
      mybookdao.deletePublishedBook(book_id);
      response.sendRedirect("Books");
   }
}