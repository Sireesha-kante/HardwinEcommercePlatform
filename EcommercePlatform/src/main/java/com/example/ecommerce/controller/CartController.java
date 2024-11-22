package com.example.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.dto.CartItemDto;
import com.example.ecommerce.dto.OrdersDto;
import com.example.ecommerce.entities.Orders;
import com.example.ecommerce.exception.AlreadyExistException;
import com.example.ecommerce.exception.ResourceNotFound;
import com.example.ecommerce.response.ApiResponse;
import com.example.ecommerce.service.CartService;

@RequestMapping("api/ecom/")
@RestController
public class CartController {
	@Autowired
	private CartService cartService;
	
	@PostMapping("/addtocart/{userId}")
	public ResponseEntity<ApiResponse> additem(@PathVariable long userId,@RequestBody CartItemDto cartItemDto)
	{
		try {
			cartService.addItem(userId,cartItemDto);
		     return  ResponseEntity.ok(new ApiResponse("sucessfully added",null));
		}
		catch(AlreadyExistException ae)
		{
			return ResponseEntity.status(HttpStatus.CONFLICT).body(new ApiResponse("unable to add to cart",null));
		}
	}
	
	@GetMapping("/viewCart/{userId}")
	public ResponseEntity<ApiResponse> viewCart(@RequestBody CartItemDto cartItemDto,@PathVariable long userId)
	{
		try {
			List<CartItemDto>cartItems=cartService.getCart( userId);
			return ResponseEntity.ok(new ApiResponse("sucess",cartItems));
		}
		catch(ResourceNotFound rnf)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Cart is empty",null));
		}
	}
	
	@DeleteMapping("/removeitem/{userId}/{productId}")
	public ResponseEntity<ApiResponse> removeItem(@PathVariable long userId, @PathVariable long productId)
	{
		try {
			cartService.removeItem( userId,productId);
			return ResponseEntity.ok(new ApiResponse("Item removed from cart",null));
		}
		catch(ResourceNotFound rnf)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Cart is empty",null));
		}
	}
	
	@DeleteMapping("/emptyCart/{userId}")
	public ResponseEntity<ApiResponse> emptyCart(@PathVariable long userId)
	{
		try {
			cartService.clearCart(userId);
			return ResponseEntity.ok(new ApiResponse(" cart is cleared",null));
		}
		catch(ResourceNotFound rnf)
		{
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new ApiResponse("no items in cart to clear",null));
		}
	}

}
