package com.capgemini.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Purpose:Application Lifecycle Listener implementation class LoginListener
 * @author JAYANTA ROY
 * @version 1.0
 * @since 04/07/18
 */
public class LoginListener implements HttpSessionListener {
	static int totalUser = 0;
	int activeUser = 0;
	ServletContext ctx;

	@Override
	public void sessionCreated(HttpSessionEvent event) {
		activeUser++;
		ctx = event.getSession().getServletContext();
		ctx.setAttribute("activeUser", activeUser);
	}

	public void sessionDestroyed(HttpSessionEvent arg0) {

		activeUser--;
		ctx.setAttribute("activeUser", activeUser);
		System.out.println("Total user logged in: " + ctx.getAttribute("totalUser"));
		System.out.println("Current Activated: " + ctx.getAttribute("activeUser"));

	}
}
