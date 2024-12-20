package com.example.ecommerce.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.dto.CartItemDto;
import com.example.ecommerce.entities.Orders;
import com.example.ecommerce.exception.ResourceNotFound;
@Service
public class CartService implements ICartService{
	
	public Map<Long,List<CartItemDto>> userCart=new HashMap();
	@Autowired
	private ProductService productService;

	@Override
	public List<CartItemDto> getCart(long userId) {
		return userCart.getOrDefault(userId, List.of()) ;
	}

	@Override
	public  void addItem(long userId, CartItemDto cartItemDto) {
		List<CartItemDto> cartItems=userCart.computeIfAbsent(userId, k->new ArrayList<>());
		double price=productService.getPriceByProductId(cartItemDto.getProductId());
		cartItemDto.setPrice(price);
				cartItems.stream()
						 .filter(item -> item.getProductId()==cartItemDto.getProductId())
						 .findFirst()
						 .ifPresentOrElse(existingItem->{
							 existingItem.setQuantity(existingItem.getQuantity()+cartItemDto.getQuantity());
							 existingItem.setTotalPrice(existingItem.getQuantity() * existingItem.getPrice());
						 }, ()-> {
							 cartItemDto.setTotalPrice(cartItemDto.getQuantity()*cartItemDto.getPrice());
							 cartItems.add(cartItemDto);
						 });
	}

	@Override
	public void removeItem(long userId, long productId) {
		
		List<CartItemDto>cartItem=userCart.get(userId);
		if(cartItem==null ||!cartItem.removeIf(cart->cart.getProductId()==productId))
		{
			throw new ResourceNotFound("No product with this Id"+productId);
		}
	}

	@Override
	public void clearCart(long userId) {
		userCart.clear();
	}

	@Override
	public double getTotalAmount(long userId) {
		return userCart.getOrDefault(userId, List.of()).stream().mapToDouble(CartItemDto::getTotalPrice).sum();
	}

	@Override
	public Orders placeOrder(long userId) {
		List<CartItemDto>cartItem=userCart.get(userId);
		if(cartItem==null ||cartItem.isEmpty())
		{
			throw new ResourceNotFound("No items in cart ");
		}
		
		double amount=getTotalAmount(userId);
		Orders order=new Orders(userId,cartItem,amount);
		userCart.remove(userId);
		return order;
	}
	
}
