package com.example.ecommerce.request;

import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


public class CreateUser {
	
	private long userId;
	private String userName;
	private String userEmail;
	private String password;
	
	public CreateUser() {
		// TODO Auto-generated constructor stub
	}

	public CreateUser(long userId, String userName, String userEmail, String password) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.password = password;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "CreateUser [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail + ", password="
				+ password + "]";
	}
	
	
}
	