package com.example.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.dto.OrdersDto;
import com.example.ecommerce.entities.Orders;
import com.example.ecommerce.exception.ResourceNotFound;
import com.example.ecommerce.response.ApiResponse;
import com.example.ecommerce.service.OrderService;

@RequestMapping("/api/ecom")
@RestController
public class OrdersController {
	
@Autowired
private OrderService orderService;


@GetMapping("placeOrder/{userId}")
public ResponseEntity<ApiResponse> placeorder(@PathVariable long userId)
{
	try {
		Orders orders=orderService.placeOrder(userId);
		OrdersDto ordersDto=orderService.convertOrdersToDTO(orders);
		 return ResponseEntity.ok(new ApiResponse("Order Placed:",orders ));
	}catch (ResourceNotFound rnf) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Noitems to place order", null));
	}
}

@GetMapping("/allOrders")
public ResponseEntity<ApiResponse> getAllOrders()
{
	try {
		 List<Orders> orders=orderService.findAllOrders();
		 List<OrdersDto> ordersDto=orderService.getConvertedOrders(orders);
		 return ResponseEntity.ok(new ApiResponse("Here is the List of Orders Placed:",ordersDto ));
	}catch (ResourceNotFound rnf) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("No orders in DB", null));
	}
}

@GetMapping("/getOrder/{orderId}")
public ResponseEntity<ApiResponse> getOrderById(@PathVariable long orderId)
{
	try {
		Orders orders=orderService.getOrderDetails(orderId);
		OrdersDto ordersDto=orderService.convertOrdersToDTO(orders);
		 return ResponseEntity.ok(new ApiResponse("sucess",ordersDto ));
	}catch (ResourceNotFound rnf) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("orderID NOT FOUND", null));
	}
}

@DeleteMapping("/deleteOrder/{orderId}")
public ResponseEntity<ApiResponse> deleteOrder(@PathVariable long  orderId)
{
	try {
		orderService.deleteOrder(orderId);
		return ResponseEntity.ok(new ApiResponse("sucess",null ));
	}catch (ResourceNotFound rnf) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("OrderID NOT FOUND", null));
	}
}
@GetMapping("/getorderBY/{userId}")
public ResponseEntity<ApiResponse> getOrderByUser(@PathVariable long userId)
{
	try {
		List<Orders> orders=orderService.getUserOrders(userId);
		List<OrdersDto> ordersDto=orderService.getConvertedOrders(orders);
		 return ResponseEntity.ok(new ApiResponse("sucess",ordersDto ));
	}catch (ResourceNotFound rnf) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("User orders NOT FOUND", null));
	}
}

}
