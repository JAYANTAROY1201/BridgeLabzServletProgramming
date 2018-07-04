package com.capgemini.controller;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.capgemini.dao.JdbcImplementation;

/**
 * Purpose:Servlet implementation class PostForgetPassword 
 * @author JAYANTA ROY
 * @version 1.0
 * @since 04/07/18
 */
public class PostForgetPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		JdbcImplementation jdbc = new JdbcImplementation();
		String from = "roy.jayanta1201"; // GMail user name (just the part before "@gmail.com")
		String pass = "30964973209"; // GMail password
		String to = request.getParameter("email");
		String subject = "password recovery mail";
		String body = "Your current password is " + jdbc.getPassword(to);
		Properties props = System.getProperties();
		String host = "smtp.gmail.com";

		props.put("mail.smtp.starttls.enable", "true");

		props.put("mail.smtp.ssl.trust", host);
		props.put("mail.smtp.user", from);
		props.put("mail.smtp.password", pass);
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");

		Session session = Session.getDefaultInstance(props);
		MimeMessage message = new MimeMessage(session);

		try 
		{
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject(subject);
			message.setText(body);
			Transport transport = session.getTransport("smtp");
			transport.connect(host, from, pass);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
		}
		catch (Exception ae) 
		{
			ae.printStackTrace();
		}
		response.sendRedirect("login");
	}
}