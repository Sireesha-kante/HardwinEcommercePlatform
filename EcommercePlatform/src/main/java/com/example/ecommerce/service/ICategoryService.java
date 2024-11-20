package com.example.ecommerce.service;

import java.util.List;

import com.example.ecommerce.dto.CategoryDto;
import com.example.ecommerce.entities.Category;

public interface ICategoryService {

	public Category  createCategory(Category category );
	public Category updateCategory(Category category, long categoryId);
	public void deleteCategory(long categoryId);
	public Category findByCategoryId(Category category,long categoryId);
	public List<Category> findAllCategories();
	public CategoryDto convertCategorytoDTO(Category category);
     
     
}
