package com.capgemini.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Purpose:Servlet implementation class PreSignup
 * @author JAYANTA ROY
 * @version 1.0
 * @since 29/06/18
 */
public class PreSignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		request.getRequestDispatcher("SignUp.jsp").forward(request, response);
	}
}
