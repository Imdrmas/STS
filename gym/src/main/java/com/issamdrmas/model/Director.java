package com.issamdrmas.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "director")
public class Director {
	@Field(value = "_id")
    private String _id;

	public Director() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Director(String _id) {
		super();
		this._id = _id;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}
	
	
   
}
