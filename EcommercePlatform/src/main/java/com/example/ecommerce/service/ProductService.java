package com.example.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.dto.ProductDto;
import com.example.ecommerce.dto.UserDto;
import com.example.ecommerce.entities.Product;
import com.example.ecommerce.entities.User;
import com.example.ecommerce.exception.AlreadyExistException;
import com.example.ecommerce.exception.ResourceNotFound;
import com.example.ecommerce.repository.ProductRepository;
import com.example.ecommerce.request.AddProduct;
import com.example.ecommerce.request.UpdateProduct;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class ProductService  implements IProductService{

	@Autowired
	private ProductRepository productRepo;
	
	@Override
	public Product createProduct(AddProduct addProduct) {
		if(productRepo.existsByproductName(addProduct.getProductName()))
		{
			throw new AlreadyExistException("This Product** " + addProduct.getProductName() + "  **already exist");
		}
		
		Product product = new Product();
		product.setProductName(addProduct.getProductName());
		product.setDescription(addProduct.getDescription());
		product.setPrice(addProduct.getPrice());
		product.setStock(addProduct.getStock());
		product.setCategory(addProduct.getCategory());
		
		
	    
	    return productRepo.save(product);
	}

	@Override
	public Product updateProduct(UpdateProduct updateProduct, long productId) {
		return productRepo.findById(productId).map( product->{
			product.setProductName(updateProduct.getProductName());
			product.setDescription(updateProduct.getDescription());
			product.setPrice(updateProduct.getPrice());
			product.setStock(updateProduct.getStock());
			product.setCategory(updateProduct.getCategory());
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
	public ProductDto convertProducttoDTO(Product product ) {
		ProductDto productDto=new ProductDto();
		productDto.setProductId(product.getProductId());
		productDto.setProductName(product.getProductName());
		productDto.setDescription(product.getDescription());
		productDto.setPrice(product.getPrice());
		productDto.setStock(product.getStock());
		productDto.setCategory(product.getCategory());
		
		return productDto;
		
	}

}
