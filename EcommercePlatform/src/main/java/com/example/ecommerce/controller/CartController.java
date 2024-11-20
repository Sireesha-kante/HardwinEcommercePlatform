package com.example.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.dto.CartItemDto;
import com.example.ecommerce.exception.AlreadyExistException;
import com.example.ecommerce.exception.ResourceNotFound;
import com.example.ecommerce.response.ApiResponse;
import com.example.ecommerce.service.CartService;

@RequestMapping("${api.prefix}/cart")
@RestController
public class CartController {
	@Autowired
	private CartService cartService;
	
	@PostMapping("/addtocart")
	public ResponseEntity<ApiResponse> additem(CartItemDto cartItemDto)
	{
		try {
			cartService.addItem(cartItemDto);
		     return  ResponseEntity.ok(new ApiResponse("sucessfully added",null));
		}
		catch(AlreadyExistException ae)
		{
			return ResponseEntity.status(HttpStatus.CONFLICT).body(new ApiResponse("unable to add to cart",null));
		}
	}
	
	@GetMapping("/viewCart")
	public ResponseEntity<ApiResponse> viewCart(@RequestBody CartItemDto cartItemDto)
	{
		try {
			List<CartItemDto>cartItems=cartService.getCart();
			return ResponseEntity.ok(new ApiResponse("sucess",cartItems));
		}
		catch(ResourceNotFound rnf)
		{
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new ApiResponse("Cart is empty",null));
		}
	}
	
	
	

}
