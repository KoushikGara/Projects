package com.BookBin.User;
 
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
 
@WebServlet({"/DeleteMembers"})
public class DeleteMembers extends HttpServlet {
   private static final long serialVersionUID = 1L;
   private MembersDAO membersDAO;
 
   public void init() {
      this.membersDAO = new MembersDAO();
   }
 
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      try {
         deleteUser(request, response);
      } catch (IOException | SQLException | ServletException e) {
         e.printStackTrace();
      }
 
   }
 
   private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
      String id = request.getParameter("id");
      membersDAO.deleteUser(id);
      System.out.println(id);
      response.sendRedirect("AllMembers");
   }
}