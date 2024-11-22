package com.example.ecommerce.service;

import java.util.List;
import com.example.ecommerce.dto.CartItemDto;
import com.example.ecommerce.dto.OrdersDto;
import com.example.ecommerce.entities.Orders;

public interface IOrderService {

	public Orders placeOrder(long userId, List<CartItemDto> cartItems, double amount);
	public void deleteOrder(long orderId);
	public Orders findByOrder(Orders orders,long OrderId);
	public List<OrdersDto> getUserOrders(long userId);
	public List<Orders> findAllOrders();
    public OrdersDto convertOrdersToDTO(Orders orders);
    public OrdersDto getOrderDetails(long orderId);
}
