package com.dvd.ecommerce.dto;

import com.dvd.ecommerce.model.Movie;

public class OrderMovieDto {
	
	private Movie movie;
	private Integer quantity;
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	

}
