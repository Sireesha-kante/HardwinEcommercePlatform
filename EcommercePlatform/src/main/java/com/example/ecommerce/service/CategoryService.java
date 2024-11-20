package com.example.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.dto.CategoryDto;
import com.example.ecommerce.entities.Category;
import com.example.ecommerce.entities.Product;
import com.example.ecommerce.exception.AlreadyExistException;
import com.example.ecommerce.exception.ResourceNotFound;
import com.example.ecommerce.repository.CategoryRepository;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class CategoryService implements ICategoryService {

	@Autowired
	private CategoryRepository categoryRepo;
	@Override
	public Category createCategory(Category category) {
		if(categoryRepo.existsById(category.getCategoryId()))
		{
			throw new AlreadyExistException("This Category** " + category.getCategoryName() + "  **already exists");
		}
		return categoryRepo.save(category);
		
	}

	@Override
	public Category updateCategory(Category category, long categoryId) {
		if(categoryRepo.existsById(category.getCategoryId()))
		{
			throw new ResourceNotFound("This Category**" +category.getCategoryName()+"Not found");
		}
		return categoryRepo.save(category);
	}

	@Override
	public void deleteCategory(long categoryId) {
		categoryRepo.findById(categoryId).ifPresentOrElse(categoryRepo::delete,()->new ResourceNotFound("Category not found") );

	}

	@Override
	public Category findByCategoryId(Category category, long categoryId) {
		return categoryRepo.findById(categoryId)
				   .orElseThrow(() -> new ResourceNotFound("Category with name " +category.getCategoryName()+ "notfound"));

	}

	@Override
	public List<Category> findAllCategories() {
		return categoryRepo.findAll();
	}

	@Override
	public CategoryDto convertCategorytoDTO(Category category) {
		CategoryDto categoryDto=new CategoryDto();
		categoryDto.setCategoryId(category.getCategoryId());
		categoryDto.setCategoryName(category.getCategoryName());
		categoryDto.setProduct(category.getProduct());
		return categoryDto;
		
		
	}

	@Override
	public List<CategoryDto> giveconvertedCategoryDTO(List<Category> category) {
		return category.stream().map(this::convertCategorytoDTO).toList();
	}

}
