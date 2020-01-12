package com.issamdrmas.model;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="restaurents")
public class Restaurant implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String restaurant_id;
private String name;
private String borough;
private String cuisine;
private Address address;
@DBRef 
private List<Grade> grades;

public Restaurant() {
	super();
	// TODO Auto-generated constructor stub
}
public Restaurant(String restaurant_id, String name, String borough, String cuisine, Address address,
		List<Grade> grades) {
	super();
	this.restaurant_id = restaurant_id;
	this.name = name;
	this.borough = borough;
	this.cuisine = cuisine;
	this.address = address;
	this.grades = grades;
}
public String getRestaurant_id() {
	return restaurant_id;
}
public void setRestaurant_id(String restaurant_id) {
	this.restaurant_id = restaurant_id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getBorough() {
	return borough;
}
public void setBorough(String borough) {
	this.borough = borough;
}
public String getCuisine() {
	return cuisine;
}
public void setCuisine(String cuisine) {
	this.cuisine = cuisine;
}
public Address getAddress() {
	return address;
}
public void setAddress(Address address) {
	this.address = address;
}
public List<Grade> getGrades() {
	return grades;
}
public void setGrades(List<Grade> grades) {
	this.grades = grades;
}



}
