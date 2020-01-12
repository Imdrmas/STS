package com.dvd.ecommerce.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="products")
public class Product {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "Product name is required.")
	@Basic(optional=false)
	private String name;
	
	@NotNull(message = "Product Description is required.")
	@Basic(optional=false)
	private String description;
	
	private Double price;
	
	private String pictureUrl;
	
	@JsonManagedReference
	@ManyToMany(fetch = FetchType.LAZY, cascade = {
			CascadeType.PERSIST, CascadeType.MERGE
	})
	@JoinTable(name = "product_tags",
	joinColumns = {@JoinColumn(name = "product_id")},
	inverseJoinColumns = {@JoinColumn(name = "tag_id")})
	private Set<Tag> tags = new HashSet<Tag>();

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(Long id, @NotNull(message = "Product name is required.") String name,
			@NotNull(message = "Product Description is required.") String description, Double price,
			String pictureUrl) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.pictureUrl = pictureUrl;
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getPictureUrl() {
		return pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}

	public Set<Tag> getTags() {
		return tags;
	}

	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}


	

}
