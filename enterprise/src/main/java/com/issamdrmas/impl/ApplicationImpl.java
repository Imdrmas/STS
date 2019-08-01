package com.issamdrmas.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.issamdrmas.dao.ApplicationRepository;
import com.issamdrmas.dto.ApplicationDto;
import com.issamdrmas.model.Application;
import com.issamdrmas.service.ApplicationService;

@Service
public class ApplicationImpl implements ApplicationService {
	
	@Autowired
	private ApplicationRepository applicationRepository;
	@Autowired
	EnterpriseFactory enterpriseFactory;

	@Override
	public List<ApplicationDto> findAllApps() {
		List<Application> applications = applicationRepository.findAll();
		List<ApplicationDto> dtos = new ArrayList<ApplicationDto>();
		
		dtos = applications.stream()
				.map(mapper -> {
					return enterpriseFactory.createApplicationDto(mapper);
				}).collect(Collectors.toList());
		return dtos;
	}

}
