package com.issamdrmas.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nameCat;
	private Date createAt;
	
	@JsonManagedReference
	@OneToMany(mappedBy="category", fetch = FetchType.LAZY)
	private List<Music> musics;
	
    @JsonManagedReference
	@OneToMany(mappedBy="category", cascade = CascadeType.ALL)
	private List<Movie> movies;
	
    @JsonManagedReference
	@OneToMany(mappedBy="category", fetch = FetchType.LAZY)
	private List<Game> games;
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Category(Long id, String nameCat, Date createAt, List<Music> musics, List<Movie> movies, List<Game> games) {
		super();
		this.id = id;
		this.nameCat = nameCat;
		this.createAt = createAt;
		this.musics = musics;
		this.movies = movies;
		this.games = games;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
   
	public String getNameCat() {
		return nameCat;
	}
	public void setNameCat(String nameCat) {
		this.nameCat = nameCat;
	}
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	public List<Music> getMusics() {
		return musics;
	}
	public void setMusics(List<Music> musics) {
		this.musics = musics;
	}
	public List<Movie> getMovies() {
		return movies;
	}
	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}
	public List<Game> getGames() {
		return games;
	}
	public void setGames(List<Game> games) {
		this.games = games;
	}
	
	

}
