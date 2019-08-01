package com.issamdrmas.dto;

import com.issamdrmas.enums.Criticality;
import com.issamdrmas.enums.Language;

public class ApplicationDto {
	private Long id;
	private String name;
	private Criticality criticality;
	private Language language;
	private EnterpriseDto enterprise;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Criticality getCriticality() {
		return criticality;
	}

	public void setCriticality(Criticality criticality) {
		this.criticality = criticality;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public EnterpriseDto getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(EnterpriseDto enterprise) {
		this.enterprise = enterprise;
	}

}
