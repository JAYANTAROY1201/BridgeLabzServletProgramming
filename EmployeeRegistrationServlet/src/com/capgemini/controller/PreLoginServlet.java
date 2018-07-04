package com.capgemini.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Purpose:Servlet implementation class PreLoginServlet
 * @author JAYANTA ROY
 * @version 1.0
 * @since 04/07/18
 */
public class PreLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		request.getRequestDispatcher("Login.jsp").forward(request, response);
	}
}
