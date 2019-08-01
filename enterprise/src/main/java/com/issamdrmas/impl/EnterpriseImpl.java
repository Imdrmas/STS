package com.issamdrmas.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.issamdrmas.calculate.CalculateCobolAndLowApps;
import com.issamdrmas.calculate.CalculateCobolApps;
import com.issamdrmas.calculate.CalculateLowApps;
import com.issamdrmas.dao.EnterpriseRepository;
import com.issamdrmas.dto.EnterpriseDto;
import com.issamdrmas.model.Enterprise;
import com.issamdrmas.service.EnterpriseService;

@Service
public class EnterpriseImpl implements EnterpriseService {
	
	@Autowired
	private EnterpriseRepository enterpriseRepository;
	@Autowired
	private EnterpriseFactory enterpriseFactory;

	@Override
	public List<EnterpriseDto> findAllEnterprise() {
		List<Enterprise> enterprises = enterpriseRepository.findAll();
		List<EnterpriseDto> enterpriseDtos = new ArrayList<EnterpriseDto>();
		
		for (Enterprise enterprise: enterprises) {
			EnterpriseDto dto = enterpriseFactory.createEnterpriseDto(enterprise);
			enterpriseDtos.add(dto);
		}
		return enterpriseDtos;
	}

	@Override
	public int calculateCobolApps(Enterprise enterprise) {
		CalculateCobolApps calculateCobolApps = new CalculateCobolApps();
		enterprise.accept(calculateCobolApps);
		return calculateCobolApps.getValue();
	}

	@Override
	public int calculateLowApps(Enterprise enterprise) {
		CalculateLowApps calculateLowApps = new CalculateLowApps();
		enterprise.accept(calculateLowApps);
		return calculateLowApps.getValue();
	}

	@Override
	public int calculateLowAndCobol(Enterprise enterprise) {
		CalculateCobolAndLowApps calculateCobolAndLowApps = new CalculateCobolAndLowApps();
		enterprise.accept(calculateCobolAndLowApps);
		return calculateCobolAndLowApps.getValue();
	}

}
