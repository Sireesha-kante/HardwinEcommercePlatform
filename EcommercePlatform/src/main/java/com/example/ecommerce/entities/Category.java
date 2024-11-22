package com.example.ecommerce.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Category {

	@Id
	@Column(name="categoryId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long categoryId;
	@Column(name="categoryName")
	private String categoryName;
	
	@JsonIgnore
	@OneToMany(mappedBy="category",cascade = CascadeType.ALL)
	private List<Product> product;

	public Category() {
		super();
	}

	public Category(long categoryId, String categoryName) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
		System.out.println(categoryName);
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + ", product=" + product + "]";
	}
	
	
}
