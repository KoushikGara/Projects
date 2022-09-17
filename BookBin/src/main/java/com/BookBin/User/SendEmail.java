package com.BookBin.User;
 
import java.io.IOException;
 
 
import java.io.PrintWriter;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
 
 
@WebServlet("/SendEmail")
public class SendEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String userId;
	RequestDispatcher dispatcher =null;
	private MyBookDAO mybookdao;
	
	public void init()
	{
		mybookdao = new MyBookDAO();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doPost(request,response);
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
	   		this.dispatcher = request.getRequestDispatcher("Help.jsp");
 
	   		for(Cookie c: cookies)
	   		{
	   			String tname = c.getName();
	   			if (tname.equals("user_id")) 
	   			{
	   				userId = c.getValue();
	   				
	   			}
	   		}
	   	}
	   	
		PrintWriter out = response.getWriter();
        response.setContentType("text/html; charset = UTF-8");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String mobile_number = request.getParameter("mobile_number");
        String  msg = request.getParameter("message");
        
        
	   	
        String nav_name = mybookdao.getUserName(msg);
        request.setAttribute("nav_name", nav_name);
        
        
        
        final String username = "koushikgarasklm1127@gmail.com";//your email id
        final String password = "hhecucswjoofonhh";// your app password
        
        
        
        Properties props = new Properties();
        props.put("mail.smtp.auth", true);
        props.put("mail.smtp.starttls.enable", true);
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        Session session = Session.getInstance(props,new javax.mail.Authenticator()
        {
        	@Override
        	protected PasswordAuthentication getPasswordAuthentication() 
        	{
        		return new PasswordAuthentication(username, password);  //instead of username try email
        	}
        });
        
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(email));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(username));
           
            MimeBodyPart textPart = new MimeBodyPart();
            Multipart multipart = new MimeMultipart();
            String final_Text = "Name: " + name + "\n" + "Email: " + email+ "\n" + "Phone: " + mobile_number + "\n" + "Mesaage: " + msg;
            textPart.setText(final_Text);
            message.setText(final_Text);           
            multipart.addBodyPart(textPart);
            message.setContent(multipart);
            
            //out.println("Sending");
            Transport.send(message);
            out.println("<center><h2 style='color:green;'>Email Sent Successfully.</h2>");
            out.println("Thank you " + name + ", your message has been submitted to us.</center>");
        } 
        catch (Exception e) 
        {
            out.println(e);
        }
        
        
        
        
	}
 
}