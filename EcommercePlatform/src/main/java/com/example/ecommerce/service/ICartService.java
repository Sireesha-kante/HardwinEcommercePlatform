package com.example.ecommerce.service;

import java.util.List;

import com.example.ecommerce.dto.CartItemDto;

public interface ICartService {
	
	public List<CartItemDto> getCart();
	public void addItem(CartItemDto cartItemDto);
	public void removeItem(long productId);
	public void clearCart();
	public double getTotalAmount();

	

}
