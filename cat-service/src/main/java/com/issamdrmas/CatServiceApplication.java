package com.issamdrmas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.issamdrmas.dao.ProduitRepository;
import com.issamdrmas.entities.Produit;

@SpringBootApplication
public class CatServiceApplication implements CommandLineRunner {

	@Autowired
	private ProduitRepository produitRepository;
	
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;
	
	public static void main(String[] args) {
		SpringApplication.run(CatServiceApplication.class, args);
		System.out.println("Executed Successfully");
	}

	@Override
	public void run(String... args) throws Exception {
		repositoryRestConfiguration.exposeIdsFor(Produit.class);
		produitRepository.save(new Produit(null, "designation1", 2100, 1));
		produitRepository.save(new Produit(null, "designation2", 2200, 2));
		produitRepository.save(new Produit(null, "designation3", 2300, 3));

		produitRepository.findAll().forEach(p->{
			System.out.println(p.toString());
		});
		
	}

}
