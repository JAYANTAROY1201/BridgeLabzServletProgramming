package com.capgemini.dao;

import com.capgemini.dto.UserBean;

public interface UserDAO {
	public UserBean setUser(String email, String password);
}
