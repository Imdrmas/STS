package com.issamdrmas.model;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="grades")
public class Grade implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@DBRef 
private String grade[];
	@DBRef 
private Integer score[];
	
public Grade() {
	super();
	// TODO Auto-generated constructor stub
}
public Grade(String[] grade, Integer[] score) {
	super();
	this.grade = grade;
	this.score = score;
}
public String[] getGrade() {
	return grade;
}
public void setGrade(String[] grade) {
	this.grade = grade;
}
public Integer[] getScore() {
	return score;
}
public void setScore(Integer[] score) {
	this.score = score;
}


}
