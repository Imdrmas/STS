package org.issamdrmas.cinema.entites;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Film implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	
	private String description;
	
	private String photo;
	
	private String realisator;
	
	private Date dateSortie;
	
	private double duree;

	@OneToMany(mappedBy = "film")
	@JsonIgnore
	private Collection<Projection> projections;
	
	@ManyToOne
	private Category category;

	public Film() {
		super();
	}

	public Film(String title, String description, String photo, String realisator, Date dateSortie, double duree,
			Collection<Projection> projections, Category category) {
		super();
		this.title = title;
		this.description = description;
		this.photo = photo;
		this.realisator = realisator;
		this.dateSortie = dateSortie;
		this.duree = duree;
		this.projections = projections;
		this.category = category;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getRealisator() {
		return realisator;
	}

	public void setRealisator(String realisator) {
		this.realisator = realisator;
	}

	public Date getDateSortie() {
		return dateSortie;
	}

	public void setDateSortie(Date dateSortie) {
		this.dateSortie = dateSortie;
	}

	public double getDuree() {
		return duree;
	}

	public void setDuree(double duree) {
		this.duree = duree;
	}

	public Collection<Projection> getProjections() {
		return projections;
	}

	public void setProjections(Collection<Projection> projections) {
		this.projections = projections;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
