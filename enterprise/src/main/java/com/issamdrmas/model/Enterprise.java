package com.issamdrmas.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.issamdrmas.visitor.Visitable;
import com.issamdrmas.visitor.Visitor;

@Entity
public class Enterprise implements Serializable, Visitable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long enterpriseId;
	@Column(columnDefinition = "VARCHAR(40)")
	private String name;
	@OneToMany(mappedBy="enterprise", cascade = CascadeType.ALL)
	private List<Application> applications;

	public Enterprise() {
		super();
	}

	public Enterprise(Long enterpriseId, String name, List<Application> applications) {
		super();
		this.enterpriseId = enterpriseId;
		this.name = name;
		this.applications = applications;
	}

	public Long getEnterpriseId() {
		return enterpriseId;
	}

	public void setEnterpriseId(Long enterpriseId) {
		this.enterpriseId = enterpriseId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Application> getApplications() {
		return applications;
	}

	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}

	public void addApplication(Application app) {
		if (getApplications() == null) {
			applications = new ArrayList<Application>();
		}
		getApplications().add(app);
		app.setEnterprise(this);
		
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
		if (getApplications() != null) {
			getApplications().forEach(applications -> {
				applications.accept(visitor);
			});
		}
		
	}




}
