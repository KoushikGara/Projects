package com.BookBin.User;
 
import java.io.IOException;
 
import java.io.PrintWriter;
 
import java.sql.*;
import java.util.Properties;
import java.util.Random;
 
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
 
@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
  
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String url = "jdbc:mysql://localhost:3306/KOUSHIK";   //jdbc:mysql://localhost:port_number/database name
		String uname = "root";
		String pass = "Gkoushik@7";
		String query = "insert into customers(username,email,mobile_number,pswd,user_type,customer_id) values(?,?,?,?,?,?)";
		
		String username =  request.getParameter("name");
		String email = request.getParameter("email");
		String mobile_number = request.getParameter("mobile_number");
		String pswd = request.getParameter("pswd");
		String re_pswd = request.getParameter("re_pswd");
		String user_type = request.getParameter("user_type");
		
		
		Random rand = new Random();
		int cust_id = rand.nextInt(5000);
		String customer_id = Integer.toString(cust_id);
		
		RequestDispatcher dispatcher = null; 
		Connection con = null;
	 
	    
	  
	    
		if(username == null || username.equals(" "))
		{
			request.setAttribute("status1", "invalidName");
			dispatcher = request.getRequestDispatcher("User.jsp");
			dispatcher.forward(request, response);
		}
		
		if(email == null || email.equals(" "))
		{
			request.setAttribute("status1", "invalidEmail");
			dispatcher = request.getRequestDispatcher("User.jsp");
			dispatcher.forward(request, response);
		}
		
		if(pswd == null ||pswd.equals(" "))
		{
			request.setAttribute("status1", "invalidpassword");
			dispatcher = request.getRequestDispatcher("User.jsp");
			dispatcher.forward(request, response);
		}
		else if(!pswd.equals(re_pswd))
		{
			request.setAttribute("status1", "invalidConfirmpassword");
			dispatcher = request.getRequestDispatcher("User.jsp");
			dispatcher.forward(request, response);
		}
		if(mobile_number == null || mobile_number.equals(" "))
		{
			request.setAttribute("status1", "invalidMobile");
			dispatcher = request.getRequestDispatcher("User.jsp");
			dispatcher.forward(request, response);
		}
		else if(mobile_number.length()> 15)
		{
			request.setAttribute("status1", "invalidMobileNumber");
			dispatcher = request.getRequestDispatcher("User.jsp");
			dispatcher.forward(request, response);
		}
		
		
		 try
		    {
		    	Class.forName("com.mysql.cj.jdbc.Driver");
		    	con = DriverManager.getConnection(url,uname,pass);
		    	PreparedStatement pst = con.prepareStatement(query);
		    	pst.setString(1, username);
		    	pst.setString(2, email);
		    	pst.setString(3, mobile_number);
		    	pst.setString(4, pswd);
		    	pst.setString(5, user_type);
		    	pst.setString(6,customer_id);
		    	
		    	int rowCount = pst.executeUpdate();
		    	dispatcher = request.getRequestDispatcher("User.jsp");
		    	
		    	if(rowCount > 0)
		    	{
		    		request.setAttribute("status1", "success");
		    	}
		    	else
		    	{
		    		request.setAttribute("status1", "failed");
		    	}
		    	
		    	dispatcher.forward(request, response);
		    }
		    
		    catch(Exception e)
		    {
		    	e.printStackTrace();
		    }
		   
		    
		
		
		
		
		
		
		
		
		
		
		
		
		
		HttpSession mySession = request.getSession();
		
		if(email!=null || !email.equals("")) 
		{
		
			String to = email;
			Properties props = new Properties();
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.socketFactory.port", "465");
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.port", "465");
			Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("koushikgarasklm1127@gmail.com", "dzzfetpeeafdinnh");// Put your email
																									// id and
																									// password here
				}
			});
			
			try {
				MimeMessage message = new MimeMessage(session);
				message.setFrom(new InternetAddress(email));// change accordingly
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
				message.setSubject("Thank You For Registering with us");
				message.setText("Hi " + username + " your id is: " + customer_id);
				// send message
				Transport.send(message);
				System.out.println("message sent successfully");
			}
 
			catch (MessagingException e) {
				throw new RuntimeException(e);
			}
			
			
			
			
			
			
			
			
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	   
	    
	    
	}
 
}