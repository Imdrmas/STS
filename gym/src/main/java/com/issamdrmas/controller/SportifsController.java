package com.issamdrmas.controller;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.issamdrmas.dao.SportifsRepository;
import com.issamdrmas.model.Sportifs;

@RestController
@CrossOrigin(origins = "*")
public class SportifsController {
	@Autowired
	SportifsRepository sportifsRepository;
	
	@GetMapping("/getAllSportifs")
	public List<Sportifs> getSportifs(){
		List<Sportifs> list = sportifsRepository.findAll();
		list = list.stream().sorted(Comparator.comparing(Sportifs::getIdSportif))
		.collect(Collectors.toList());
		return list;
	}
	
	@GetMapping("/getSportifById={idSportif}")
	public List<Sportifs> getSportsById(@PathVariable int idSportif) {
		return sportifsRepository.findByIdSportif(idSportif);
	}
	@GetMapping("/getSportifBySexe={sexe}")
	public List<Sportifs> getSportsById(@PathVariable String sexe) {
		return sportifsRepository.findBySexe(sexe);
	}

}
