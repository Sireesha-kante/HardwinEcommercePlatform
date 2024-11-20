package com.example.ecommerce.dto;

import java.time.LocalDateTime;
import java.util.List;
import com.example.ecommerce.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Data
@Getter
@Setter
@ToString
public class OrdersDto {

private long orderId;
	
	private long userId;
	private LocalDateTime orderDate;
	private Double totalAmount;
	private List<Product> products;
	private UserDto userDto;
	public OrdersDto(long orderId, long userId, LocalDateTime orderDate, Double totalAmount, List<Product> products,
			UserDto userDto) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
		this.products = products;
		this.userDto = userDto;
	}
	public OrdersDto() {
		super();
	}
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public LocalDateTime getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}
	public Double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public UserDto getUserDto() {
		return userDto;
	}
	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
	}
	@Override
	public String toString() {
		return "OrdersDto [orderId=" + orderId + ", userId=" + userId + ", orderDate=" + orderDate + ", totalAmount="
				+ totalAmount + ", products=" + products + ", userDto=" + userDto + "]";
	}
	
	
}
