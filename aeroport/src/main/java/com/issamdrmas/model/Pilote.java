package com.issamdrmas.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pilote")
public class Pilote implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	public Long piloteId;
	private String code;
	private String name;
	private String site;
	
	public Pilote() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}
	public Long getPiloteId() {
		return piloteId;
	}

	public void setPiloteId(Long piloteId) {
		this.piloteId = piloteId;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}


}
