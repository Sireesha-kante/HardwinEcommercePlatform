package com.example.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.jaxb.SpringDataJaxb.OrderDto;
import org.springframework.stereotype.Service;

import com.example.ecommerce.dto.CartItemDto;
import com.example.ecommerce.dto.OrdersDto;
import com.example.ecommerce.dto.ProductDto;
import com.example.ecommerce.entities.Orders;
import com.example.ecommerce.entities.Product;
import com.example.ecommerce.exception.AlreadyExistException;
import com.example.ecommerce.exception.ResourceNotFound;
import com.example.ecommerce.repository.OrdersRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService implements IOrderService {

	@Autowired
	private  OrdersRepository orderRepo;
	
	@Autowired
	private CartService cartService;
	
	@Override
	public void deleteOrder(long orderId) {
		orderRepo.findById(orderId).ifPresentOrElse(orderRepo::delete,()->new ResourceNotFound("Order not found") );
		
	}


	@Override
	public List<Orders> findAllOrders() {
		return orderRepo.findAll();
	}

	@Override
	public OrdersDto convertOrdersToDTO(Orders orders) {
		OrdersDto orderDto=new OrdersDto();
		orderDto.setOrderId(orders.getOrderId());
		orderDto.setOrderDate(orders.getOrderDate());
		orderDto.setTotalAmount(orders.getTotalAmount());
		orderDto.setUserId(orders.getUserId());
		return orderDto;
		
	}
	@Override
	public List<OrdersDto> getConvertedOrders(List<Orders> orders) {
		
		return orders.stream().map(this::convertOrdersToDTO).toList();
	}

	@Override
	public Orders placeOrder(long userId) {
		Orders order=cartService.placeOrder(userId);
		return orderRepo.save(order);
	}

	@Override
	public List<Orders> getUserOrders(long userId) {
		List<Orders>orders=orderRepo.findByUserId(userId);
		  return orders;
	}

	@Override
	public Orders getOrderDetails(long orderId) {
		Orders orders=orderRepo.findById(orderId).orElseThrow(() -> new ResourceNotFound("Order not found"));
		return orders;
	}
	

}
