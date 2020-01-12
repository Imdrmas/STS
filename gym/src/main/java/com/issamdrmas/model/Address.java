package com.issamdrmas.model;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="address")
public class Address implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String building;
private String street;
private String zipcode;
private Double coord[];
public Address() {
	super();
	// TODO Auto-generated constructor stub
}
public Address(String building, String street, String zipcode, Double[] coord) {
	super();
	this.building = building;
	this.street = street;
	this.zipcode = zipcode;
	this.coord = coord;
}
public String getBuilding() {
	return building;
}
public void setBuilding(String building) {
	this.building = building;
}
public String getStreet() {
	return street;
}
public void setStreet(String street) {
	this.street = street;
}
public String getZipcode() {
	return zipcode;
}
public void setZipcode(String zipcode) {
	this.zipcode = zipcode;
}
public Double[] getCoord() {
	return coord;
}
public void setCoord(Double[] coord) {
	this.coord = coord;
}


}
