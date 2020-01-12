package com.issamdrmas.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.issamdrmas.dao.GymnasesRepository;
import com.issamdrmas.model.Gymnases;

@Service
@Transactional
public class GymnasesServiceImpl implements GymnasesService {
	
	@Autowired
	private GymnasesRepository gymnasesRepository;
	

	public GymnasesServiceImpl(GymnasesRepository gymnasesRepository) {
		super();
		this.gymnasesRepository = gymnasesRepository;
	}


	@Override
	public void create(Gymnases gymnases) {
		gymnasesRepository.save(gymnases);
		
	}


	@Override
	public Collection<Gymnases> getAllGymnases() {
		return gymnasesRepository.findAll();
	}


	@Override
	public Optional<Gymnases> findById(int id) {
		return null;
	}


	@Override
	public void delete(int id) {
	//	gymnasesRepository.deleteById(id);
		
	}


	@Override
	public void update(Gymnases gymnases) {
		gymnasesRepository.save(gymnases);
		
	}


	@Override
	public void deleteAll() {
		gymnasesRepository.deleteAll();
		
	}



}
