package com.example.ecommerce.service;

import java.util.List;

import com.example.ecommerce.dto.ProductDto;
import com.example.ecommerce.entities.Product;
import com.example.ecommerce.request.AddProduct;
import com.example.ecommerce.request.UpdateProduct;


public interface IProductService {

	
	public  Product createProduct(AddProduct addProduct );
	public Product updateProduct(UpdateProduct updateProduct, long productId);
	public void deleteProduct(long productId);
	public Product findByProduct(Product product,long productId);
	public List<Product> findAllProducts();
	public List<Product>getProductsByCategory(String category);
	public List<Product>getProductsByCategoryandPrice(String category, double price);
	public Long countProductsbyCategory(String category);
	public ProductDto convertProducttoDTO(Product product);
	public List<ProductDto> getConvertedProducts(List<Product> product);
}
