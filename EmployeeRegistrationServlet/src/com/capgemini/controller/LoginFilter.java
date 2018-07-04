package com.capgemini.controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import com.capgemini.dao.JdbcImplementation;

/**
 * Purpose:Servlet Filter implementation class LoginFilter
 * @author JAYANTA ROY
 * @version 1.0
 * @since 04/07/18
 */
public class LoginFilter implements Filter {

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		JdbcImplementation jdbc = new JdbcImplementation();
		if (jdbc.checkEmail(email) == false) {
			System.out.println("email checking");
			((HttpServletResponse) response).sendRedirect("signup");
		} else {
			if (jdbc.checkPassword(email, password) == false) {
				((HttpServletResponse) response).sendRedirect("relogin");
			} else {
				chain.doFilter(request, response);
			}
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
}
