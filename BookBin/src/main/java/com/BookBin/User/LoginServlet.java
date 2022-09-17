package com.BookBin.User;
 
import java.io.IOException;
 
import java.sql.*;
import java.io.PrintWriter;
 
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
 
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		/*PrintWriter out = response.getWriter();
		out.println("Working!");*/
		
		
		String url = "jdbc:mysql://localhost:3306/KOUSHIK";   //jdbc:mysql://localhost:port_number/database name
		String uname = "root";
		String pass = "Gkoushik@7";
		String query = "select * from customers where email = ? and pswd = ? and user_type = ?";
		
		
		
		String email = request.getParameter("email");
		String pswd  = request.getParameter("pswd");
		String user_type = request.getParameter("user_type");
		
		RequestDispatcher dispatcher = null;		
		HttpSession session = request.getSession();
		Connection con  = null;
		
		if(email == null || email.equals(" "))
		{
			request.setAttribute("status2", "invalidEmail");
			dispatcher = request.getRequestDispatcher("User.jsp");
			dispatcher.forward(request, response);
		}
		
		if(pswd == null ||pswd.equals(" "))
		{
			request.setAttribute("status2", "invalidpassword");
			dispatcher = request.getRequestDispatcher("User.jsp");
			dispatcher.forward(request, response);
		}
		
		if(user_type == null ||user_type.equals(" "))
		{
			request.setAttribute("status2", "invalidusertype");
			dispatcher = request.getRequestDispatcher("User.jsp");
			dispatcher.forward(request, response);
		}
		
		
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,uname,pass);
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, email);
			pst.setString(2, pswd);
			pst.setString(3, user_type);
			
			
			
			ResultSet rs = pst.executeQuery();
			
	
			
			/*if(rs.next())
			{
				session.setAttribute("name", rs.getString("username"));  //used to have the email id of specific customer
				dispatcher = request.getRequestDispatcher("Admin.jsp");
			}*/
			
			if(!rs.next())
			{
				request.setAttribute("status2", "failed");
				dispatcher = request.getRequestDispatcher("User.jsp");
				dispatcher.forward(request, response);
			}
			
			
			//Creating userid cookie
			String userId = rs.getString("customer_id");
			Cookie c = new Cookie("user_id",userId);
			response.addCookie(c);
			//Creating username cookie
			String username = rs.getString("username");
			Cookie c2 = new Cookie("user_name",username);
			response.addCookie(c2);
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		if(user_type.equals("Admin"))
		{
			dispatcher = request.getRequestDispatcher("AdminBooks");
			dispatcher.forward(request, response);
		}
		else if(user_type.equals("Customer"))
		{
			dispatcher = request.getRequestDispatcher("CustomerServlet");
			dispatcher.forward(request, response);
		}
		
		
		
	}
 
}