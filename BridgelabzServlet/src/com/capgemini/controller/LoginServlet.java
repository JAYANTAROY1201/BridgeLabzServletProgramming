package com.capgemini.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.capgemini.dao.JdbcImplementation;
import com.capgemini.dto.UserBean;


public class LoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
	    JdbcImplementation jdbc= new JdbcImplementation();
	    UserBean userValue=jdbc.authenticate(email, password);
	    if(userValue!=null)
		{
	    	System.out.println(userValue.getUserName());
			HttpSession session =request.getSession(true);
			session.setMaxInactiveInterval(1*60);		
			session.setAttribute("currentUser", userValue);  
		
			String htmlresp="<html>"+"<title>"+"WELCOME TO CAPGEMINI"+
					"</title>"+"<body>"+"<h2>"+"LOGIN SUCCESSFULL"+"</h2>"+
					"<p>"+ "Welcome "+ ((UserBean) session.getAttribute("currentUser")).getUserName()+"</p><br>"+
					"<form action=\"Logout\" method=\"post\"><input type=\"submit\" value=\"LOGOUT\"></form>";				
					PrintWriter out=response.getWriter();
					response.setContentType("text/html");
					out.println(htmlresp);
			
		}
	    else
		{
			request.getRequestDispatcher("Login.html").forward(request, response);
		}
	}//end of dopost
}//end of class