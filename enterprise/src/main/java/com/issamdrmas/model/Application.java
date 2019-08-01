package com.issamdrmas.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.issamdrmas.enums.Criticality;
import com.issamdrmas.enums.Language;
import com.issamdrmas.visitor.Visitable;
import com.issamdrmas.visitor.Visitor;

@Entity
public class Application implements Visitable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long applicationId;
	@Column(columnDefinition="VARCHAR(40)")
	private String name;
	private Language language;
	private Criticality criticality;
	@OneToOne(cascade = CascadeType.ALL)
	private User user;
	@ManyToOne
	private Enterprise enterprise;

	public Application() {
		super();
		
	}

	public Application(String name, Criticality criticality, Language language, User user) {
		super();
		this.name = name;
		this.language = language;
		this.criticality = criticality;
		this.user = user;
	}

	public Long getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(Long applicationId) {
		this.applicationId = applicationId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public Criticality getCriticality() {
		return criticality;
	}

	public void setCriticality(Criticality criticality) {
		this.criticality = criticality;
	}

	public Enterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);	
	}


	

}
