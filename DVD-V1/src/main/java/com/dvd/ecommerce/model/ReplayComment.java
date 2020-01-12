package com.dvd.ecommerce.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="comments_replay")
public class ReplayComment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@NotNull(message = "Message is required")
	private String messageReplay;
	
	private String addedBy;
	
	private String addedAt;
	
	private long commentId;

	public ReplayComment() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public ReplayComment(long id,
			@NotNull(message = "Message is required") String messageReplay, String addedBy, String addedAt, long commentId) {
		super();
		this.id = id;
		this.messageReplay = messageReplay;
		this.addedBy = addedBy;
		this.addedAt = addedAt;
		this.commentId = commentId;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
 

	public String getMessageReplay() {
		return messageReplay;
	}


	public void setMessageReplay(String messageReplay) {
		this.messageReplay = messageReplay;
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


	public long getCommentId() {
		return commentId;
	}


	public void setCommentId(long commentId) {
		this.commentId = commentId;
	}
	
	

}
