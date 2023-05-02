package com.moive.servie;

import com.moive.entity.User;
import com.moive.model.UserLogin;

public interface UserService {

	public boolean adduser(User user);

	public boolean loginUser(UserLogin userlogin);

	public boolean updateUser(User user);

}
