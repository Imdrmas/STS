package com.issamdrmas.dto;

public class ProductDto {
    private Long id;
    
    private String name;

    private Double price;

    private String pictureUrl;
    
    private String description;
    
    private String createAt;
    
    private int quantity;

	public ProductDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductDto(Long id, String name, Double price, String pictureUrl, String description, String createAt,
			int quantity) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.pictureUrl = pictureUrl;
		this.description = description;
		this.createAt = createAt;
		this.quantity = quantity;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreateAt() {
		return createAt;
	}

	public void setCreateAt(String createAt) {
		this.createAt = createAt;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
    
    
}
