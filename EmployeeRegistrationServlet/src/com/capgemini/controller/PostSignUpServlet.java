package com.capgemini.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;

/**
 * Purpose:Servlet class designed for perform signup
 * @author JAYANTA ROY
 * @version 1.0
 * @since 04/07/18
 */
public class PostSignUpServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("Signupsuccess.jsp").forward(request, response);
	}
}
