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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		JdbcImplementation jdbc = new JdbcImplementation();
		UserBean userValue = jdbc.authenticate(email, password);
		if (userValue != null) {
			HttpSession session = request.getSession(true);
			session.setMaxInactiveInterval(1 * 60);
			session.setAttribute("currentUser", userValue.getUserName());
            
			//request.getRequestDispatcher("LoginSuccessfull").forward(request, response);
			response.sendRedirect("login-successfull");
			

		} else {
			//request.getRequestDispatcher("PreLoginServlet").forward(request, response);
			response.sendRedirect("relogin");
		}
	}// end of dopost
}// end of class