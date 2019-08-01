package com.issamdrmas.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "todos")
public class Todo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Size(min = 10, message = "Enter at least 10 Characters...")
	private String description;
	
	private Date targetDate;
	
	private boolean isDone;
    
    public Todo() {
		// TODO Auto-generated constructor stub
	}


	public Todo(String name, @Size(min = 10, message = "Enter at least 10 Characters...") String description,
			Date targetDate, boolean isDone) {
		super();
		this.name = name;
		this.description = description;
		this.targetDate = targetDate;
		this.isDone = isDone;
	}



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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}
    
    

}
