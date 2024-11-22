package com.example.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.dto.ProductDto;
import com.example.ecommerce.entities.Category;
import com.example.ecommerce.entities.Product;
import com.example.ecommerce.exception.AlreadyExistException;
import com.example.ecommerce.exception.ResourceNotFound;
import com.example.ecommerce.repository.CategoryRepository;
import com.example.ecommerce.repository.ProductRepository;
import com.example.ecommerce.request.AddProduct;
import com.example.ecommerce.request.UpdateProduct;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class ProductService  implements IProductService{

	@Autowired
	private ProductRepository productRepo;
	@Autowired
	private CategoryRepository categoryRepo;
	
	@Override
	public Product createProduct(AddProduct addProduct, long categoryId) {
		if(productRepo.existsByproductName(addProduct.getProductName()))
		{
			throw new AlreadyExistException("This Product** " + addProduct.getProductName() + "  **already exist");
		}
		
		Product product = new Product();
		Optional<Category> category= categoryRepo.findById(categoryId);
		product.setCategory(category.get());
		product.setProductName(addProduct.getProductName());
		product.setDescription(addProduct.getDescription());
		product.setPrice(addProduct.getPrice());
		product.setStock(addProduct.getStock());
	    return productRepo.save(product);
	}

	@Override
	public Product updateProduct(UpdateProduct updateProduct, long productId) {
		return productRepo.findById(productId).map( product->{
			product.setProductName(updateProduct.getProductName());
			product.setDescription(updateProduct.getDescription());
			product.setPrice(updateProduct.getPrice());
			product.setStock(updateProduct.getStock());
			return productRepo.save(product);
			   
		}).orElseThrow(()->new ResourceNotFound("Product not found"));

	}

	@Override
	public void deleteProduct(long productId) {
		productRepo.findById(productId).ifPresentOrElse(productRepo::delete,()->new ResourceNotFound("Product not found") );

		
	}

	@Override
	public Product findByProduct(Product product, long productId) {
		return productRepo.findById(productId)
				   .orElseThrow(() -> new AlreadyExistException("Product with name " +product.getProductName()+ "notfound"));

	}

	@Override
	public List<Product> findAllProducts() {
		return productRepo.findAll();
	}

	@Override
	public ProductDto convertProducttoDTO(Product product) {
		ProductDto productDto=new ProductDto();
		productDto.setProductId(product.getProductId());
		productDto.setProductName(product.getProductName());
		productDto.setDescription(product.getDescription());
		productDto.setPrice(product.getPrice());
		productDto.setStock(product.getStock());
		productDto.setCategory(product.getCategory());
		
		return productDto;
		
	}

	@Override
	public List<Product> getProductsByCategory(String category) {
		return	productRepo.findByCategory_CategoryName(category);
			 	
	}

	@Override
	public List<Product> getProductsByCategoryandPrice(String category, double price) {
		
		return productRepo.findByCategory_CategoryNameAndPrice(category,price);
	}

	@Override
	public Long countProductsbyCategory(String category) {
		
		return productRepo.countByCategory_CategoryName(category);
	}

	@Override
	public List<ProductDto> getConvertedProducts(List<Product> product) {
		
		return product.stream().map(this::convertProducttoDTO).toList();
	}

}
