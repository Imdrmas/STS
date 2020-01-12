package com.issamdrmas.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Gymnases {
	@Id
    int IdGymnase;
	String NomGymnase;
	String adress;
	String Ville;
	int Surfance;
	@DBRef
	List<Seances> seances;
	public Gymnases() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Gymnases(int idGymnase, String nomGymnase, String adress, String ville, int surfance,
			List<Seances> seances) {
		super();
		IdGymnase = idGymnase;
		NomGymnase = nomGymnase;
		this.adress = adress;
		Ville = ville;
		Surfance = surfance;
		this.seances = seances;
	}
	public int getIdGymnase() {
		return IdGymnase;
	}
	public void setIdGymnase(int idGymnase) {
		IdGymnase = idGymnase;
	}
	public String getNomGymnase() {
		return NomGymnase;
	}
	public void setNomGymnase(String nomGymnase) {
		NomGymnase = nomGymnase;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getVille() {
		return Ville;
	}
	public void setVille(String ville) {
		Ville = ville;
	}
	public int getSurfance() {
		return Surfance;
	}
	public void setSurfance(int surfance) {
		Surfance = surfance;
	}
	public List<Seances> getSeances() {
		return seances;
	}
	public void setSeances(List<Seances> seances) {
		this.seances = seances;
	}
	
	
}
