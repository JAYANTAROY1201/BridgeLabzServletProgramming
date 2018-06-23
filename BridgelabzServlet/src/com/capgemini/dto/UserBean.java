package com.capgemini.dto;

public class UserBean {
	private String email;
	private String userName;
	private String password;
	public UserBean()
	{
		this.email=email;
		this.userName=userName;
		this.password=password;
	}
	public String getUserName() {
		return userName;
	}
	public void setuserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return email;
	}
	public void setUserEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
