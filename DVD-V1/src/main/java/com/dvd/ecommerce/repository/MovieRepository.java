package com.dvd.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;

import com.dvd.ecommerce.model.Movie;

public interface MovieRepository extends CrudRepository<Movie, Long> {

}
