package com.capgemini.dto;

import java.io.Serializable;

/**
 * Purpose:This class is designed as a pojo class of user
 * @author JAYANTA ROY
 * @version 1.0
 * @since 
 */
public class UserBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private int serial_no;
	private String email;
	private String userName;
	private String password;
	private String mobile;
	
	/**
	 * 
	 */
	public UserBean()
	{
	}
	
	/**
	 * @return
	 */
	public int getId() {
		return serial_no;
	}
	/**
	 * @param serial_no
	 */
	public void setId(int serial_no) {
		this.serial_no = serial_no;
	}
	
	/**
	 * @return
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName
	 */
	public void setuserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return
	 */
	public String getUserEmail() {
		return email;
	}
	/**
	 * @param email
	 */
	public void setUserEmail(String email) {
		this.email = email;
	}
	/**
	 * @return
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * @param mobile
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
}
