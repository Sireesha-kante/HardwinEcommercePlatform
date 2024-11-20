package com.example.ecommerce.dto;

import java.util.List;
import com.example.ecommerce.entities.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data

@Getter
@Setter

@ToString
public class CategoryDto {

private long categoryId;
	
	private String categoryName;

	private List<Product> product;
	
	public CategoryDto() {
		// TODO Auto-generated constructor stub
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
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	public CategoryDto(long categoryId, String categoryName, List<Product> product) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.product = product;
	}

	@Override
		public String toString() {
			// TODO Auto-generated method stub
			return super.toString();
		}
}

