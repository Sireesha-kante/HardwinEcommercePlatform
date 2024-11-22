package com.example.ecommerce.service;

import java.util.List;

import com.example.ecommerce.dto.CartItemDto;
import com.example.ecommerce.entities.Orders;

public interface ICartService {
	
	public List<CartItemDto> getCart(long userId);
	public  void addItem(long userId, CartItemDto cartItemDto);
	public void removeItem(long userId, long productId);
	public void clearCart(long userId);
	public double getTotalAmount(long userId);
	public Orders placeOrder(long userId);

	

}
