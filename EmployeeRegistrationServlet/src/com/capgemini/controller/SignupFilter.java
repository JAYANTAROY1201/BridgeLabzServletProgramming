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
 * Servlet Filter implementation class SignupFilter
 */
public class SignupFilter implements Filter {

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("destroy ho gaya");
		System.gc();
		
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String email=request.getParameter("email");
		String user_name=request.getParameter("user_name");
		String password=request.getParameter("password");
		String mobile=request.getParameter("mobile");
		
			JdbcImplementation jdbc=new JdbcImplementation();
			if(jdbc.dataEnrty(email,user_name, password,mobile)==1) {
				chain.doFilter(request, response);
			}
			else
			{
			((HttpServletResponse) response).sendRedirect("resignup");
			}		
	}
		

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
