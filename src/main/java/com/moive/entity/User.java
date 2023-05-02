package com.moive.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class User {

	@Id
	@Column(unique = true,nullable = false)
	private String email;
	
	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String password;
	@Column(unique = true,nullable = false)
	private double mobileNo;

	@Column(nullable = false)
	private String question;

	@Column(nullable = false)
	private String answer;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String name, String email, String password, double mobileNo, String question, String answer) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.mobileNo = mobileNo;
		this.question = question;
		this.answer = answer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(double mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", password=" + password + ", mobileNo=" + mobileNo
				+ ", Question=" + question + ", answer=" + answer + "]";
	}
	
		
}
