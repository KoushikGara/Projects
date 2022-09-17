  package com.BookBin.User;
 

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Properties;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 
@WebServlet({"/SendEmailToUser"})
public class SendEmailToUser extends HttpServlet {
   private static final long serialVersionUID = 1L;
 
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String name = request.getParameter("name");
      String email = request.getParameter("email");
      String sub = request.getParameter("sub");
      String msg = request.getParameter("message");
      RequestDispatcher dispatcher = null;
      HttpSession mySession = request.getSession();
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
         message.setFrom(new InternetAddress(email));
         message.addRecipient(RecipientType.TO, new InternetAddress(to));
         message.setSubject(sub);
         message.setText("Hi !" + name + " , Hope You are doing well " + "\n" + msg);
         Transport.send(message);
         System.out.println("message sent successfully");
      } catch (MessagingException e) {
			throw new RuntimeException(e);
		}
 
      dispatcher = request.getRequestDispatcher("Message.jsp");
      dispatcher.forward(request, response);
   }
}