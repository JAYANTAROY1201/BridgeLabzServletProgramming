package com.capgemini.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.capgemini.dao.JdbcImplementation;
import com.capgemini.dto.UserBean;

/**
 * Purpose:Servlet class for LoginServlet
 * @author JAYANTA ROY
 * @version 1.0
 * @since 29/06/18
 */
public class PostLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		JdbcImplementation jdbc = new JdbcImplementation();
		ServletContext ctx=getServletContext();
		LoginListener.totalUser++;
		ctx.setAttribute("totalUser", LoginListener.totalUser);
		UserBean userValue = jdbc.setUser(email, password);
		if (userValue != null) 
		{
			HttpSession session = request.getSession(true);
			session.setMaxInactiveInterval(1 * 30);
			session.setAttribute("currentUser", userValue.getUserName());			
			request.getRequestDispatcher("Welcome.jsp").forward(request, response);
		}
		System.out.println("Total user logged in: "+ctx.getAttribute("totalUser"));
		System.out.println("Current Activated: "+ctx.getAttribute("activeUser"));
		
	}// end of dopost
}// end of class