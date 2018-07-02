package com.capgemini.dto;

import java.io.Serializable;

public class UserBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private int serial_no;
	private String email;
	private String userName;
	private String password;
	private String mobile;
	
	public UserBean()
	{
	}
	
	public int getId() {
		return serial_no;
	}
	public void setId(int serial_no) {
		this.serial_no = serial_no;
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
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
}
