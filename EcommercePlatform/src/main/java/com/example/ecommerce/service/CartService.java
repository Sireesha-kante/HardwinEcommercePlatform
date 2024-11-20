package com.example.ecommerce.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.ecommerce.dto.CartItemDto;
import com.example.ecommerce.exception.ResourceNotFound;
@Service
public class CartService implements ICartService{
	
	private List<CartItemDto> cartItem;

	@Override
	public List<CartItemDto> getCart() {
		return cartItem;
	}

	@Override
	public void addItem(CartItemDto cartItemDto) {
		cartItem.stream().filter(cart->cart.getProductId().equals(cartItemDto.getProductId()))
					     .findFirst()
					     .ifPresentOrElse(existingItem->{
					    	 existingItem.setQuantity(existingItem.getQuantity()+cartItemDto.getQuantity());
					    	 existingItem.setTotalPrice(existingItem.getQuantity()*existingItem.getPrice());
					     }, ()->{
					    	 cartItemDto.setTotalPrice(cartItemDto.getQuantity()*cartItemDto.getPrice());
					      cartItem.add(cartItemDto);
					     });
	}

	@Override
	public void removeItem(long productId) {
		
		boolean isRemoved=cartItem.removeIf(cart->cart.getProductId().equals(productId));
		
		if(!isRemoved)
		{
			throw new ResourceNotFound("No Product with productId" +productId+"present in cart");
		}	
	}

	@Override
	public void clearCart() {
		cartItem.clear();
	}

	@Override
	public double getTotalAmount() {
		return cartItem.stream().mapToDouble(CartItemDto::getTotalPrice).sum();
	}

}
