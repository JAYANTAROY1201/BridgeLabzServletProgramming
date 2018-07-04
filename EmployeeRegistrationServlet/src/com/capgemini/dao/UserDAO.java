package com.capgemini.dao;

import com.capgemini.dto.UserBean;

/**
 * Purpose: This interface for only user data access
 * @author JAYANTA ROY
 * @version 1.0
 * @since 04/08/17
 */
public interface UserDAO {
	public UserBean setUser(String email, String password);
}
