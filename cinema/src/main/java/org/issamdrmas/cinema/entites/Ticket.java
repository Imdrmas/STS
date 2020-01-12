package org.issamdrmas.cinema.entites;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Ticket implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nameClient;
	
	private double prix;
	
	@Column(unique = false, nullable=true)
	private int codePayement;
	
	private boolean reserve;
	
	@ManyToOne
	private Place place;
	
	@ManyToOne
	// @JsonProperty(access=Access.WRITE_ONLY)
	private Projection projection;

	public Ticket() {
		super();
	}

	public Ticket(String nameClient, double prix, int codePayement, boolean reserve, Place place,
			Projection projection) {
		super();
		this.nameClient = nameClient;
		this.prix = prix;
		this.codePayement = codePayement;
		this.reserve = reserve;
		this.place = place;
		this.projection = projection;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNameClient() {
		return nameClient;
	}

	public void setNameClient(String nameClient) {
		this.nameClient = nameClient;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getCodePayement() {
		return codePayement;
	}

	public void setCodePayement(int codePayement) {
		this.codePayement = codePayement;
	}

	public boolean isReserve() {
		return reserve;
	}

	public void setReserve(boolean reserve) {
		this.reserve = reserve;
	}

	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

	public Projection getProjection() {
		return projection;
	}

	public void setProjection(Projection projection) {
		this.projection = projection;
	}

}
