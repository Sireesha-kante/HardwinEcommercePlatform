package com.example.ecommerce.service;

import java.util.List;
import com.example.ecommerce.dto.CartItemDto;
import com.example.ecommerce.dto.OrdersDto;
import com.example.ecommerce.dto.ProductDto;
import com.example.ecommerce.entities.Orders;
import com.example.ecommerce.entities.Product;

public interface IOrderService {

	public Orders placeOrder(long userId);
	public void deleteOrder(long orderId);
	public List<Orders> getUserOrders(long userId);
	public List<Orders> findAllOrders();
    public OrdersDto convertOrdersToDTO(Orders orders);
    public Orders getOrderDetails(long orderId);
	public List<OrdersDto> getConvertedOrders(List<Orders> orders);
	
}
