package org.issamdrmas.cinema.entites;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Salle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private int nombrePlace;
	
	@ManyToOne
	@JsonIgnore
	private Cinema cinema;
	
	@JsonIgnore
	@OneToMany(mappedBy = "salle")
	private Collection<Place> places;
	
	@JsonIgnore
	@OneToMany(mappedBy = "salle")
	private Collection<Projection> projections;

	public Salle() {
		super();
	}

	public Salle(Long id, String name, int nombrePlace, Cinema cinema, Collection<Place> places,
			Collection<Projection> projections) {
		super();
		this.id = id;
		this.name = name;
		this.nombrePlace = nombrePlace;
		this.cinema = cinema;
		this.places = places;
		this.projections = projections;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNombrePlace() {
		return nombrePlace;
	}

	public void setNombrePlace(int nombrePlace) {
		this.nombrePlace = nombrePlace;
	}

	public Cinema getCinema() {
		return cinema;
	}

	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}

	public Collection<Place> getPlaces() {
		return places;
	}

	public void setPlaces(Collection<Place> places) {
		this.places = places;
	}

	public Collection<Projection> getProjections() {
		return projections;
	}

	public void setProjections(Collection<Projection> projections) {
		this.projections = projections;
	}

}
