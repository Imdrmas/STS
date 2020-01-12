package com.issamdrmas.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.issamdrmas.model.Gymnases;

@Service
public interface GymnasesService {
	void create(Gymnases gymnases);
    Collection<Gymnases> getAllGymnases();
    Optional<Gymnases> findById(int id);
    void delete (int id);
    void update(Gymnases gymnases);
    void deleteAll();
}
