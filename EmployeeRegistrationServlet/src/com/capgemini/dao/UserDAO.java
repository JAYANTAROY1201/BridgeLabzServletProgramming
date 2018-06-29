package com.capgemini.dao;

import com.capgemini.dto.UserBean;

public interface UserDAO {
	public UserBean authenticate(String userName, String password);
}
