package com.dvd.ecommerce.dto;

public class ReplayCommentDto {

	private Long id;
	
	private String addedBy;
	
	private String addedAt;
	

	public ReplayCommentDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReplayCommentDto(Long id, String addedBy, String addedAt) {
		super();
		this.id = id;
		this.addedBy = addedBy;
		this.addedAt = addedAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
