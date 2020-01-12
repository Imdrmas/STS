package com.issamdrmas.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "movies")
public class Movie {
	
	@Field(value="_id")
	private String _id;
	
	@Field(value="title")
	private String title;
	
	@Field(value="genre")
	private String genre;
	
	@Field(value="summary")
	private String summary;
	
	@Field(value="country")
	private String country;
	
	@Field(value="year")
	private int year;
	
	private Director director;
	
	@DBRef
	private List<Actor> actors;

	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Movie(String _id, String title, String genre, String summary, String country, int year, Director director,
			List<Actor> actors) {
		super();
		this._id = _id;
		this.title = title;
		this.genre = genre;
		this.summary = summary;
		this.country = country;
		this.year = year;
		this.director = director;
		this.actors = actors;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Director getDirector() {
		return director;
	}

	public void setDirector(Director director) {
		this.director = director;
	}

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}
	
	
	

}
