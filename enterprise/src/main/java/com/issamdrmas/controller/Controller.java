package com.issamdrmas.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.issamdrmas.dao.EnterpriseRepository;
import com.issamdrmas.dao.UserRepository;
import com.issamdrmas.dto.ApplicationDto;
import com.issamdrmas.dto.EnterpriseDto;
import com.issamdrmas.model.Enterprise;
import com.issamdrmas.model.User;
import com.issamdrmas.service.ApplicationService;
import com.issamdrmas.service.EnterpriseService;

@RestController
public class Controller {
	
	@Autowired
	EnterpriseService enterpriseService;
	@Autowired
	EnterpriseRepository enterpriseRepository;
	@Autowired
	ApplicationService applicationService;
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/")
	public String home() {
		return "Welcome tp BNP enterprise";
	}
	
	@GetMapping("/findAllEnterprise")
	public List<EnterpriseDto> findAllEnterprise(){
		return enterpriseService.findAllEnterprise();
	}
	
	@GetMapping("/cobol/{enterpriseId}")
	public int CalculateCobolApps(@PathVariable Long enterpriseId) {
		Optional<Enterprise> enterpriseOptional = enterpriseRepository.findById(enterpriseId);
		if (enterpriseOptional.isPresent()) {
			return enterpriseService.calculateCobolApps(enterpriseOptional.get());
		}else {
			throw new RuntimeException("Enterprise not found");
		}
	}
	@GetMapping("/low/{enterpriseId}")
	public int CalculateLowApps(@PathVariable Long enterpriseId) {
		Optional<Enterprise> enterpriseOptional = enterpriseRepository.findById(enterpriseId);
		if (enterpriseOptional.isPresent()) {
			return enterpriseService.calculateLowApps(enterpriseOptional.get());
		}
		else {
			throw new RuntimeException("Enterprise not found");
		}
	}
	@GetMapping("/lowAndCobol/{enterpriseId}")
	public int CalculateCobolAndLowApps(@PathVariable Long enterpriseId) {
		Optional<Enterprise> enterpriseOptional = enterpriseRepository.findById(enterpriseId);
		if (enterpriseOptional.isPresent()) {
			return enterpriseService.calculateLowAndCobol(enterpriseOptional.get());
		}
		else {
			throw new RuntimeException("Enterprise not found");
		}
	}
	@GetMapping("/findAllApps")
	public List<ApplicationDto> findAllApps(){
		return applicationService.findAllApps();
	}
	@GetMapping("/findAllUsers")
	public List<User> findAllUsers(){
		return userRepository.findAll();
	}

}
