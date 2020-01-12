package com.issamdrmas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Book {
 
    @Id
    @GeneratedValue
    private Long id;
 
    @Column(name="notes",columnDefinition="LONGTEXT")
    private String notes;

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(String notes) {
		super();
		this.notes = notes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
    
    
    

} 