package com.issamdrmas.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Seances {
	int IdSportifEntraineur;
	String Jour;
	int Horaire;
	int Duree;
	String Libelle;
	@DBRef
	List<Gymnases> gymnases;
	public Seances() {
		super();
		// TODO Auto-generated constructor stub
	}
    
	public Seances(int idSportifEntraineur, String jour, int horaire, int duree, String libelle,
			List<Gymnases> gymnases) {
		super();
		IdSportifEntraineur = idSportifEntraineur;
		Jour = jour;
		Horaire = horaire;
		Duree = duree;
		Libelle = libelle;
		this.gymnases = gymnases;
	}

	public int getIdSportifEntraineur() {
		return IdSportifEntraineur;
	}
	public void setIdSportifEntraineur(int idSportifEntraineur) {
		IdSportifEntraineur = idSportifEntraineur;
	}
	public String getJour() {
		return Jour;
	}
	public void setJour(String jour) {
		Jour = jour;
	}
	public int getHoraire() {
		return Horaire;
	}
	public void setHoraire(int horaire) {
		Horaire = horaire;
	}
	public int getDuree() {
		return Duree;
	}
	public void setDuree(int duree) {
		Duree = duree;
	}
	public String getLibelle() {
		return Libelle;
	}
	public void setLibelle(String libelle) {
		Libelle = libelle;
	}

	public List<Gymnases> getGymnases() {
		return gymnases;
	}

	public void setGymnases(List<Gymnases> gymnases) {
		this.gymnases = gymnases;
	}
	
	

}
