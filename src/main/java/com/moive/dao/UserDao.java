package com.moive.dao;

import com.moive.entity.User;

public interface UserDao {

	public boolean adduser(User user);
	public User getUser(String email);
	public boolean updateUser(User user);
}
