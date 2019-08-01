package com.issamdrmas.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "avion")
public class Avion implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
public Long avionId;
private String code;
private String constructeur;
private String model;
private int capicite;
private String site;

public Avion() {
	super();
	// TODO Auto-generated constructor stub
}

public Long getAvionId() {
	return avionId;
}


public void setAvionId(Long avionId) {
	this.avionId = avionId;
}


public String getCode() {
	return code;
}


public void setCode(String code) {
	this.code = code;
}


public String getConstructeur() {
	return constructeur;
}

public void setConstructeur(String constructeur) {
	this.constructeur = constructeur;
}

public String getModel() {
	return model;
}

public void setModel(String model) {
	this.model = model;
}

public int getCapicite() {
	return capicite;
}

public void setCapicite(int capicite) {
	this.capicite = capicite;
}

public String getSite() {
	return site;
}

public void setSite(String site) {
	this.site = site;
}


}
