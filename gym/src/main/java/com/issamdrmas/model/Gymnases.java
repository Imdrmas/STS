package com.issamdrmas.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document(collection = "Gymnases")
public class Gymnases {

	@Field(value="IdGymnase")
	private int idGymnase;
	@Field(value="NomGymnase")
	private String nomGymnase;
	@Field(value="Adresse")
	private String adresse;
	@Field(value="Ville")
	private String ville;
	@Field(value="Surface")
	private int surface;
	@DBRef 
	private List<Seances> Seances;
	
	public Gymnases() {
		super();
	}

	public Gymnases(int idGymnase, String nomGymnase, String adresse, String ville, int surface,
			List<com.issamdrmas.model.Seances> seances) {
		super();
		this.idGymnase = idGymnase;
		this.nomGymnase = nomGymnase;
		this.adresse = adresse;
		this.ville = ville;
		this.surface = surface;
		Seances = seances;
	}

	public int getIdGymnase() {
		return idGymnase;
	}

	public void setIdGymnase(int idGymnase) {
		this.idGymnase = idGymnase;
	}

	public String getNomGymnase() {
		return nomGymnase;
	}

	public void setNomGymnase(String nomGymnase) {
		this.nomGymnase = nomGymnase;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public int getSurface() {
		return surface;
	}

	public void setSurface(int surface) {
		this.surface = surface;
	}

	public List<Seances> getSeances() {
		return Seances;
	}

	public void setSeances(List<Seances> seances) {
		Seances = seances;
	}

    
	
	

}
