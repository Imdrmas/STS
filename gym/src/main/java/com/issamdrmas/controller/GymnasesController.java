package com.issamdrmas.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.issamdrmas.dao.GymnasesRepository;
import com.issamdrmas.model.Gymnases;

@RestController
@CrossOrigin(origins = "*")
public class GymnasesController {
	
	@Autowired
	GymnasesRepository gymnasesRepository;
	
	
	public GymnasesController(GymnasesRepository gymnasesRepository) {
		super();
		this.gymnasesRepository = gymnasesRepository;
	}
	@PostMapping("/create")
	public void create(@RequestBody Gymnases gymnases) {
		gymnasesRepository.save(gymnases);	
	}
	@GetMapping("/getAllGymnases")
	public List<Gymnases>   geGymnases(){
		List<Gymnases> list = gymnasesRepository.findAll();
		return list;
		
	}
	@GetMapping("/findById={idGymnase}")
	public List<Gymnases> findByID(@PathVariable int idGymnase) {
		return gymnasesRepository.findByIdGymnase(idGymnase);
	
		
	}
	@GetMapping("/findByName={nomGymnase}")
	public List<Gymnases> findByNomGymnase(@PathVariable String nomGymnase){
		return gymnasesRepository.findByNomGymnase(nomGymnase);
	}
	@GetMapping("/findByVille={Ville}")
	public List<Gymnases> findByVille(@PathVariable("Ville") String Ville) {
		return gymnasesRepository.findByVille(Ville);
	
	}
	@GetMapping("/findBySurface={surface}")
	public List<Gymnases> findByVille(@PathVariable("surface") int surface) {
		return gymnasesRepository.findBySurface(surface);
	
	}
	@GetMapping("/findByLibelle={libelle}")
	public List<Gymnases> findByLibelle(@PathVariable("libelle") String libelle) {
		return gymnasesRepository.findSeanceByLibelle(libelle);
		
	}
	@GetMapping("/findByHoraire={horaire}")
	public List<Gymnases> findByHoraire(@PathVariable int horaire) {
		return gymnasesRepository.findSeanceByHoraire(horaire);
		
	}
	@GetMapping("/findByJour={jour}")
	public List<Gymnases> findByJour(@PathVariable String jour) {
		return gymnasesRepository.findSeanceByJour(jour);
		
	}
}
