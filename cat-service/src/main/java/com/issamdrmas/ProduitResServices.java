package com.issamdrmas;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.issamdrmas.dao.ProduitRepository;
import com.issamdrmas.entities.Produit;

@CrossOrigin("*")
@RestController
public class ProduitResServices {
	
	@Autowired
	private ProduitRepository produitRepository;
	
	@GetMapping(value = "/listProduits")
	public List<Produit> listProduits(){
		return produitRepository.findAll();
	}
	@GetMapping(value = "/listProduits{id}")
	public Produit ontProduit(@PathVariable(name="id")Long id){
		return produitRepository.findById(id).get();
	}
	@PostMapping(value = "/listProduits{id}")
	public Produit update(@PathVariable(name="id")Long id, @RequestBody Produit produit){
		produit.setId(id);
		return produitRepository.save(produit);
	}
	@PostMapping(value = "/listProduits")
	public Produit save(@RequestBody Produit produit){
		return produitRepository.save(produit)
;	}
	@DeleteMapping(value = "/listProduits{id}")
	public void deleteProduit(@PathVariable(name="id")Long id) {
		produitRepository.deleteById(id);
	}

}
