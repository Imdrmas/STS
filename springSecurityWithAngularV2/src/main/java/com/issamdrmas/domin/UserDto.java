package com.issamdrmas.domin;

import com.issamdrmas.model.User;

public class UserDto {
	private User user;
	private String token;
	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserDto(User user, String token) {
		super();
		this.user = user;
		this.token = token;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	

}
