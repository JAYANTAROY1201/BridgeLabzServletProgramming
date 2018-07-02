package com.capgemini.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;


/**
 * Servlet implementation class PreLoginServlet
 */
public class PreLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.getRequestDispatcher("Login.jsp").forward(request, response);

		
	}
}
