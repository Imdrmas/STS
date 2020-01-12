package com.issamdrmas.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "artistes")
public class Artiste {

	@Field(value = "_id")
	private String _id;

	@Field(value = "last_name")
	private String last_name;

	@Field(value = "first_name")
	private String first_name;

	@Field(value = "birth_date")
	private String birth_date;

	public Artiste() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Artiste(String _id, String last_name, String first_name, String birth_date) {
		super();
		this._id = _id;
		this.last_name = last_name;
		this.first_name = first_name;
		this.birth_date = birth_date;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(String birth_date) {
		this.birth_date = birth_date;
	}
	
	

}
