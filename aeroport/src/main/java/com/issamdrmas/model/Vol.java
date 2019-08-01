package com.issamdrmas.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;




@Entity
public class Vol implements Serializable {

	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    public Long volId;
  	private String code;
	private String heurArrive;
	private String heureDepart;
	private String siteArrive;
	private String siteDepart;
	private String piloteCode;
	private String avionCode;
    
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
     
	public Long getVolId() {
		return volId;
	}

	public void setVolId(Long volId) {
		this.volId = volId;
	}

	public String getPiloteCode() {
		return piloteCode;
	}

	public void setPiloteCode(String piloteCode) {
		this.piloteCode = piloteCode;
	}

	public String getAvionCode() {
		return avionCode;
	}

	public void setAvionCode(String avionCode) {
		this.avionCode = avionCode;
	}

	public Vol() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getHeurArrive() {
		return heurArrive;
	}
	public void setHeurArrive(String heurArrive) {
		this.heurArrive = heurArrive;
	}
	public String getHeureDepart() {
		return heureDepart;
	}
	public void setHeureDepart(String heureDepart) {
		this.heureDepart = heureDepart;
	}
	public String getSiteArrive() {
		return siteArrive;
	}
	public void setSiteArrive(String siteArrive) {
		this.siteArrive = siteArrive;
	}
	public String getSiteDepart() {
		return siteDepart;
	}
	public void setSiteDepart(String siteDepart) {
		this.siteDepart = siteDepart;
	}


}