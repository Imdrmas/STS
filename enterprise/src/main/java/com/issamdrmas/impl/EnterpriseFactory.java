package com.issamdrmas.impl;

import org.springframework.stereotype.Component;

import com.issamdrmas.dto.ApplicationDto;
import com.issamdrmas.dto.EnterpriseDto;
import com.issamdrmas.model.Application;
import com.issamdrmas.model.Enterprise;

@Component
public class EnterpriseFactory {	
	public EnterpriseDto createEnterpriseDto(Enterprise enterprise) {
		EnterpriseDto enterpriseDto = new EnterpriseDto();
		enterpriseDto.setEnterpriseId(enterprise.getEnterpriseId());
		enterpriseDto.setName(enterprise.getName());
		return enterpriseDto;
	}
	
	public ApplicationDto createApplicationDto(Application application) {
		ApplicationDto dto = new ApplicationDto();
		dto.setId(application.getApplicationId());
		dto.setCriticality(application.getCriticality());
		dto.setLanguage(application.getLanguage());
		dto.setName(application.getName());
		dto.setEnterprise(createEnterpriseDto(application.getEnterprise()));
		return dto;
	}

}
