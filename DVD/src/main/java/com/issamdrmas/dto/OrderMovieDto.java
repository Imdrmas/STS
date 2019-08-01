package com.issamdrmas.dto;

import com.issamdrmas.model.Movie;

public class OrderMovieDto {
     private Movie movie;
     private int quantity;

	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
     
     
}
