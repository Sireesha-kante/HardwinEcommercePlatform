package com.example.ecommerce.service;

import java.util.List;

import com.example.ecommerce.dto.OrdersDto;
import com.example.ecommerce.dto.ProductDto;
import com.example.ecommerce.entities.Orders;
import com.example.ecommerce.entities.Product;

public interface IOrderService {

	
	public void deleteOrder(long orderId);
	public Orders findByOrder(Orders orders,long OrderId);
	public List<Orders> findAllOrders();
     public OrdersDto convertOrdersToDTO(Orders orders);
}
