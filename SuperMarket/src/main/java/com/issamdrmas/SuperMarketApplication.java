package com.issamdrmas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.issamdrmas.dao.SuperMarketDao;
import com.issamdrmas.model.SuperMarket;

@SpringBootApplication
public class SuperMarketApplication implements CommandLineRunner {
	
	@Autowired
	SuperMarketDao superMarketDao;

	public static void main(String[] args) {
		SpringApplication.run(SuperMarketApplication.class, args);
		System.out.println("App started successfully");
	}

	@Override
	public void run(String... args) throws Exception {
		superMarketDao.save(new SuperMarket("Shoes", 100, "15/8/2018"));
		superMarketDao.save(new SuperMarket("T-shirt", 100, "15/8/2018"));
		superMarketDao.save(new SuperMarket("Jeans", 100, "15/8/2018"));
		superMarketDao.save(new SuperMarket("Pants", 100, "15/8/2018"));
		superMarketDao.save(new SuperMarket("Skirts", 100, "15/8/2018"));
        superMarketDao.save(new SuperMarket("Bermuda", 100, "15/8/2018"));
		
	}

}
