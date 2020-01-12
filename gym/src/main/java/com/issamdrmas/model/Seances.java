package com.issamdrmas.model;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "Seances")
public class Seances {
	@Field("IdSportifEntraineur")
	private int idSportifEntraineur;
	@Field("Jour")
	private String jour;
	@Field("Horaire")
	private int horaire;
	@Field("Duree")
	private int duree;
	@Field("Libelle")
	private String libelle;


	public Seances() {
		super();
	}


	public Seances(int idSportifEntraineur, String jour, int horaire, int duree, String libelle) {
		super();
		this.idSportifEntraineur = idSportifEntraineur;
		this.jour = jour;
		this.horaire = horaire;
		this.duree = duree;
		this.libelle = libelle;
	}


	public int getIdSportifEntraineur() {
		return idSportifEntraineur;
	}


	public void setIdSportifEntraineur(int idSportifEntraineur) {
		this.idSportifEntraineur = idSportifEntraineur;
	}


	public String getJour() {
		return jour;
	}


	public void setJour(String jour) {
		this.jour = jour;
	}


	public int getHoraire() {
		return horaire;
	}


	public void setHoraire(int horaire) {
		this.horaire = horaire;
	}


	public int getDuree() {
		return duree;
	}


	public void setDuree(int duree) {
		this.duree = duree;
	}


	public String getLibelle() {
		return libelle;
	}


	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
    

  
}
