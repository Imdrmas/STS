package com.issamdrmas.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "note")
@JsonIgnoreProperties(value = {"createAt", "updateAt"})
public class Note {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
	@NotBlank
private String title;
	@NotBlank
private String content;
	@Column(nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
private Date createAt;
	@Column(nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
private Date updateAt;

}
