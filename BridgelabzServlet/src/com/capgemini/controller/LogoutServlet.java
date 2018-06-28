package com.capgemini.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		HttpSession  session=request.getSession(false);
		
		if(session!=null)
		{
			session.invalidate();
			
		}
		out.println("<h3 style=\"color:white; background-color:red\">You have Successfully Logged out from application..See you again..!!!</h3>");
		RequestDispatcher dispatcher=request.getRequestDispatcher("HomePage.html");
		dispatcher.include(request, response);
	}

}
