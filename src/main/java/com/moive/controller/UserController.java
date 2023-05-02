package com.moive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moive.entity.Movie;
import com.moive.entity.User;
import com.moive.exception.ResourceAlreadyExistException;
import com.moive.model.UserLogin;
import com.moive.servie.UserService;

@RestController
@RequestMapping(value="/user")
public class UserController {

	@Autowired
	UserService	service;
	
	@PostMapping(value="/register-user")
	public ResponseEntity<Boolean> adduser(@RequestBody User user) {
		
		boolean isAdded = service.adduser(user);
		if (isAdded) {
			return new ResponseEntity<Boolean>(isAdded, HttpStatus.CREATED);
		} else {
			// throw custom exception ( ResourceAlreadyExistsExceptio(String msg) )
			return new ResponseEntity<Boolean>(isAdded, HttpStatus.ALREADY_REPORTED);
		}
	}
	@PostMapping(value="/login")
	public ResponseEntity<Boolean> loginUser(@RequestBody UserLogin userlogin){
		boolean isLogin = service.loginUser(userlogin);
		if(isLogin) {
			return new ResponseEntity<Boolean>(isLogin,HttpStatus.OK);
		}else {
			throw new ResourceAlreadyExistException("Invalid Credentials please check your user id OR password!");
		}
	}
	@PostMapping("/update-user")
	public ResponseEntity<Boolean> updateUser(@RequestBody User user){
		boolean isUpdated=service.updateUser(user);
		
		return new ResponseEntity<Boolean>(isUpdated,HttpStatus.OK);
	}
}