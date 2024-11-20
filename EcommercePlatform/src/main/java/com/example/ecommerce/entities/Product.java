package com.example.ecommerce.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="productId")
	private long productId;
	@Column(name="productName",nullable = false)
	private String productName;
	@Column(name="productDescription")
	private String Description;
	@Column(name="productPrice")
	private Double price;
	@Column(name="productStock")
	private int stock;
	
	@ManyToOne
	@JoinColumn(name="categoryid")
	private Category category;

	public Product() {
		super();
	}

	public Product(long productId, String productName, String description, Double price, int stock, Category category) {
		super();
		this.productId = productId;
		this.productName = productName;
		Description = description;
		this.price = price;
		this.stock = stock;
		this.category = category;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", Description=" + Description
				+ ", price=" + price + ", stock=" + stock + ", category=" + category + "]";
	}
}