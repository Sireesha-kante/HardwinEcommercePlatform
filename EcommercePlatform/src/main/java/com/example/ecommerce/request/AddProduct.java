package com.example.ecommerce.request;

import com.example.ecommerce.entities.Category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data

public class AddProduct {
	
	private long productId;
	private String productName;
	private String Description;
	private Double price;
	private int stock;
	private Category category;
	
	public AddProduct() {
		// TODO Auto-generated constructor stub
	}

	public AddProduct(long productId, String productName, String description, Double price, int stock,
			Category category) {
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
		return "AddProduct [productId=" + productId + ", productName=" + productName + ", Description=" + Description
				+ ", price=" + price + ", stock=" + stock + ", category=" + category + "]";
	}

	
	
}
