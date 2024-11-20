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
import com.example.ecommerce.dto.ProductDto;
import com.example.ecommerce.entities.Product;
import com.example.ecommerce.exception.AlreadyExistException;
import com.example.ecommerce.exception.ResourceNotFound;
import com.example.ecommerce.request.AddProduct;
import com.example.ecommerce.request.UpdateProduct;
import com.example.ecommerce.response.ApiResponse;
import com.example.ecommerce.service.ProductService;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@RequestMapping("${api.prefix}/products")
@RestController
public class ProductController {
	@Autowired
	private  ProductService productService;
	
	@GetMapping("/allProducts")
	public ResponseEntity<ApiResponse> getAllProducts()
	{
		try {
			 List<Product> product=productService.findAllProducts();
			 List<ProductDto> productDto=productService.getConvertedProducts(product);
			 return ResponseEntity.ok(new ApiResponse("Here is the List of USERS:",productDto ));
		}catch (ResourceNotFound rnf) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("No Products in DB", null));
		}
	}
	@PutMapping("/{productId}/getProduct")
	 public ResponseEntity<ApiResponse> getProductById(@RequestBody Product product,@PathVariable long productId)
	 {
		 try {
			 Product productbyId = productService.findByProduct(product,productId );
			 ProductDto productDto=productService.convertProducttoDTO(productbyId);
			 return ResponseEntity.ok(new ApiResponse("Sucess",productDto)); 
		 }catch (ResourceNotFound rnf) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("no Product found",null));
		}
	 }
	@PostMapping("/addProduct")
	public ResponseEntity<ApiResponse>  insertProduct(@RequestBody AddProduct addProduct)
	{
	 try {
		 Product product=productService.createProduct(addProduct);
		 ProductDto productDto=productService.convertProducttoDTO(product);
		 return ResponseEntity.ok(new ApiResponse("Sucess",productDto)); 
	 }
	 catch(AlreadyExistException ae) {
		 return ResponseEntity.status(HttpStatus.CONFLICT).body(new ApiResponse(ae.getMessage(),null) );
	 }
	 
	}
	
	@PutMapping("/{productId}updateProduct")
	public ResponseEntity<ApiResponse> updateProduct(@RequestBody UpdateProduct updateProduct,@PathVariable long productId)
	{
		 try {
			 Product product=productService.updateProduct(updateProduct,productId);
			 ProductDto productDto=productService.convertProducttoDTO(product);
			 return ResponseEntity.ok(new ApiResponse("Update Sucessful",productDto)); 
		 }
		 catch(ResourceNotFound rnf) {
			 return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(rnf.getMessage(),null) );
		 }
	}
	@DeleteMapping("/{productId}deleteProduct")
	public ResponseEntity<ApiResponse> deletProduct(@PathVariable long productId)
	{
		try {
			 productService.deleteProduct(productId);
			 return ResponseEntity.ok(new ApiResponse("Product removed from db",null));
			
		}catch (ResourceNotFound rnf) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("no data found", null));
		}
		 
	}
	
	
	@GetMapping("/{category}productbycategory")
	public ResponseEntity<ApiResponse> getProductsByCategories(@PathVariable String category)
	{
	   try {
		   List<Product> products=productService.getProductsByCategory(category);
			List<ProductDto> productsDto=productService.getConvertedProducts(products);
			return ResponseEntity.ok(new ApiResponse("Sucess",productsDto));
	   }
	   catch (ResourceNotFound rnf) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("no data found", null));
		}
	}
	
	@GetMapping("/productby{category}and{price}")
	public ResponseEntity<ApiResponse> getProductsByCategoriesandPrice(@PathVariable String category, @PathVariable int price)
	{
		try {
			List<Product> products=productService.getProductsByCategoryandPrice(category, price);
			List<ProductDto> productsDto=productService.getConvertedProducts(products);
			return ResponseEntity.ok(new ApiResponse("Sucess",productsDto));
		} catch (ResourceNotFound rnf) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("no data found", null));
		}
	}
	@GetMapping("/listofproductsin{category}")
	public ResponseEntity<ApiResponse> countProductsbyCategories(@PathVariable String category)
	{
		try {
			Long products=productService.countProductsbyCategory(category);
			return ResponseEntity.ok(new ApiResponse("Sucess",products));
		} catch (ResourceNotFound rnf) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("no data found", null));
		}
	}
}
