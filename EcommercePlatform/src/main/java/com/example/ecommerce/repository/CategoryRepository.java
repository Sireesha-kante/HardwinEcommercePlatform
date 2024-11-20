package com.example.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ecommerce.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

	public boolean existsBycategoryId(long categoryId);
	

}
