package com.example.ecommerce.request;

import com.example.ecommerce.entities.Category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data

public class UpdateProduct {
	
	private String productName;
	private String Description;
	private Double price;
	private int stock;
	private Category category;
	
	public UpdateProduct() {
		// TODO Auto-generated constructor stub
	}

	public UpdateProduct(String productName, String description, Double price, int stock) {
		super();
		this.productName = productName;
		Description = description;
		this.price = price;
		this.stock = stock;
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
		return "UpdateProduct [productName=" + productName + ", Description=" + Description + ", price=" + price
				+ ", stock=" + stock + ", category=" + category + "]";
	}

	
	

}