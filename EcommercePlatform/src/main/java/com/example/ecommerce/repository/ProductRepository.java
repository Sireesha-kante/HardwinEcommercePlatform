package com.example.ecommerce.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.ecommerce.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long>{

public 	boolean existsByproductName(String productName);
public List<Product> findByCategory_CategoryName(String categoryName);
public List<Product> findByCategory_CategoryNameAndPrice(String categoryName, double price);
public	Long countByCategory_CategoryName(String categoryName);
}



