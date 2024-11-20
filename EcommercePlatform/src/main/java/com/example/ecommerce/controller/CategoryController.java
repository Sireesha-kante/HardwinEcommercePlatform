package com.example.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.dto.CategoryDto;
import com.example.ecommerce.entities.Category;
import com.example.ecommerce.exception.AlreadyExistException;
import com.example.ecommerce.exception.ResourceNotFound;
import com.example.ecommerce.response.ApiResponse;
import com.example.ecommerce.service.CategoryService;

@RestController
@RequestMapping("${api.prefix}/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/createCategory")
	public ResponseEntity<ApiResponse>  insertCategory(@RequestBody Category category )
	{
	 try {
		 Category categories=categoryService.createCategory(category);
		 CategoryDto categoryDto=categoryService.convertCategorytoDTO(categories);
		 return ResponseEntity.ok(new ApiResponse("Sucess",categoryDto)); 
	 }
	 catch(AlreadyExistException ae) {
		 return ResponseEntity.status(HttpStatus.CONFLICT).body(new ApiResponse(ae.getMessage(),null) );
		 
	 }
	}
	
	@PutMapping("{categoryId}updatecategory")
	public ResponseEntity<ApiResponse> updateCategory(Category category, @PathVariable long categoryId)
	{
		 try {
			 Category categories=categoryService.updateCategory(category, categoryId);
			 CategoryDto categoryDto=categoryService.convertCategorytoDTO(categories);
			 return ResponseEntity.ok(new ApiResponse("Sucess",categoryDto)); 
		 }
		 catch(ResourceNotFound rnf) {
			 return ResponseEntity.status(HttpStatus.CONFLICT).body(new ApiResponse(rnf.getMessage(),null) );
			 
		 }
	}
	@DeleteMapping("/{categoryId}deletecategory")
	public ResponseEntity<ApiResponse> deleteCategory(@PathVariable long categoryId)
	{
		try {
			 categoryService.deleteCategory(categoryId);
			 return ResponseEntity.ok(new ApiResponse("Category Deleted",null));
		}
		 catch(ResourceNotFound rnf) {
			 return ResponseEntity.status(HttpStatus.CONFLICT).body(new ApiResponse(rnf.getMessage(),null) ); 
		 }
	}
	
	@GetMapping("/{categoryId}getcategory")
	public ResponseEntity<ApiResponse> getCategoryBasedOnId(@RequestBody Category category, @PathVariable long categoryId)
	{
		try {
			Category categories=categoryService.findByCategoryId(category, categoryId);
			CategoryDto categoryDto=categoryService.convertCategorytoDTO(categories);
			 return ResponseEntity.ok(new ApiResponse("sucess",categoryDto));
		}
		 catch(ResourceNotFound rnf) {
			 return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(rnf.getMessage(),null) ); 
             }
	}
	@GetMapping("/getallcategory")
	public ResponseEntity<ApiResponse> getAllCategories()
	{
		try {
			List<Category> category=categoryService.findAllCategories();
			List<CategoryDto> categoryDto=categoryService.giveconvertedCategoryDTO(category);
			return ResponseEntity.ok(new ApiResponse("Sucess",categoryDto));
		}
		 catch(ResourceNotFound rnf) {
			 return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(rnf.getMessage(),null) ); 
             }
	}
}
