package com.capgemini.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.capgemini.dao.JdbcImplementation;

public class SignUpServlet extends HttpServlet {
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		String user_name=request.getParameter("user_name");
		String password=request.getParameter("password");
		String mobile=request.getParameter("mobile");
		try {
			JdbcImplementation jdbc=new JdbcImplementation();
			if(jdbc.dataEnrty(email,user_name, password,mobile)==1) {
			response.sendRedirect("signup-successfull");
			}
			else
			{
				response.sendRedirect("resignup");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
