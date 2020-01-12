package com.issamdrmas.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Sports")
public class Sports {

	String[] Jouer;
	String[] Arbitrer;
	String[] Entrainer;
	
	public Sports(String[] jouer, String[] arbitrer, String[] entrainer) {
		super();
		Jouer = jouer;
		Arbitrer = arbitrer;
		Entrainer = entrainer;
	}
	public Sports() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String[] getJouer() {
		return Jouer;
	}
	public void setJouer(String[] jouer) {
		Jouer = jouer;
	}
	public String[] getArbitrer() {
		return Arbitrer;
	}
	public void setArbitrer(String[] arbitrer) {
		Arbitrer = arbitrer;
	}
	public String[] getEntrainer() {
		return Entrainer;
	}
	public void setEntrainer(String[] entrainer) {
		Entrainer = entrainer;
	}
	
	

}
