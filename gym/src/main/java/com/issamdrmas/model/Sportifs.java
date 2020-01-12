package com.issamdrmas.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="Sportifs")
public class Sportifs {
	@Field(value="IdSportif")
	int idSportif;
	@Field(value="Nom")
	String nom;
	@Field(value="Prenom")
	String prenom;
	@Field(value="Sexe")
	String sexe;
	@Field(value="Age")
	int age;
	@Field(value="IdSportifConseiller")
	int idSportifConseiller;
	Sports Sports;
   
	public Sportifs() {
		super();
	}

	public Sportifs(int idSportif, String nom, String prenom, String sexe, int age, int idSportifConseiller,
			com.issamdrmas.model.Sports sports) {
		super();
		this.idSportif = idSportif;
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
		this.age = age;
		this.idSportifConseiller = idSportifConseiller;
		Sports = sports;
	}

	public int getIdSportif() {
		return idSportif;
	}

	public void setIdSportif(int idSportif) {
		this.idSportif = idSportif;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getIdSportifConseiller() {
		return idSportifConseiller;
	}

	public void setIdSportifConseiller(int idSportifConseiller) {
		this.idSportifConseiller = idSportifConseiller;
	}

	public Sports getSports() {
		return Sports;
	}

	public void setSports(Sports sports) {
		Sports = sports;
	}
    

	
	

}
