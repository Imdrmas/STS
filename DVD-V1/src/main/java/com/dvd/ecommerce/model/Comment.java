package com.dvd.ecommerce.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="comments")
public class Comment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@NotNull(message = "Title is required")
	private String title;
	@NotNull(message = "Message is required")
	private String message;
	
	private String addedBy;
	
	private String addedAt;

	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Comment(long id, @NotNull(message = "Title is required") String title,
			@NotNull(message = "Message is required") String message, String addedBy, String addedAt) {
		super();
		this.id = id;
		this.title = title;
		this.message = message;
		this.addedBy = addedBy;
		this.addedAt = addedAt;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getAddedBy() {
		return addedBy;
	}

	public void setAddedBy(String addedBy) {
		this.addedBy = addedBy;
	}


	public String getAddedAt() {
		return addedAt;
	}


	public void setAddedAt(String addedAt) {
		this.addedAt = addedAt;
	}
	
	

}
