package com.moive.serviceIMPL;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moive.dao.UserDao;
import com.moive.entity.User;
import com.moive.model.UserLogin;
import com.moive.servie.UserService;

@Service
public class UserServiceIMPL implements UserService {

	@Autowired
	UserDao dao;
	@Override
	public boolean adduser(User user) {

	return dao.adduser(user);
	}
	@Override
	public boolean loginUser(UserLogin userlogin) {
		String email= userlogin.getEmail();
		String pass = userlogin.getPassword();
	
		boolean isLogin=false;
		User user = dao.getUser(email);
		
		if(user!=null) {
			if(pass.equals(user.getPassword())) {
				isLogin = true;
			}else {
				isLogin = false;
			}		
		}			
		return isLogin;
	}
	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return dao.updateUser(user);
	}
}
