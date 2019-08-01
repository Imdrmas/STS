package com.issamdrmas.service;

import java.util.List;

import com.issamdrmas.dto.EnterpriseDto;
import com.issamdrmas.model.Enterprise;

public interface EnterpriseService {
	List<EnterpriseDto> findAllEnterprise();
	int calculateCobolApps(Enterprise enterprise);
	int calculateLowApps(Enterprise enterprise);
	int calculateLowAndCobol(Enterprise enterprise);

}
