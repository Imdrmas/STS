package com.issamdrmas.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "actors")
public class Actor {

	@Id
	@Field(value="_id")
	private String _id;
	
	@Field(value="role")
	private String role;


	public Actor(String _id, String role) {
		super();
		this._id = _id;
		this.role = role;
	}

	public Actor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
}
