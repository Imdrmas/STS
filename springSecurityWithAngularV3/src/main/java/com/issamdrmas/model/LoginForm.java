package com.issamdrmas.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class LoginForm {
	
	@NotBlank
	@Size(min=3, max=60)
	private String username = "issamdrmas";

	@NotBlank
	@Size(min=3, max=60)
	private String password = "drmas123";

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
