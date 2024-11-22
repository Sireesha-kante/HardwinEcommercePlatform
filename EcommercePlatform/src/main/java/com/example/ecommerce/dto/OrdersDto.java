package com.example.ecommerce.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.example.ecommerce.entities.OrderItems;
import com.example.ecommerce.entities.Product;
import com.example.ecommerce.entities.User;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

public class OrdersDto {

	private long orderId;
	private long userId;
	private LocalDate orderDate;
	private Double totalAmount;
	private User user;
	private List<OrderItems> orderItems;
	public OrdersDto() {
		super();
	}
	public OrdersDto(long orderId, long userId, LocalDate orderDate, Double totalAmount, User user,
			List<OrderItems> orderItems) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
		this.user = user;
		this.orderItems = orderItems;
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
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate localDate) {
		this.orderDate = localDate;
	}
	public Double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<OrderItems> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItems> orderItems) {
		this.orderItems = orderItems;
	}
	@Override
	public String toString() {
		return "OrdersDto [orderId=" + orderId + ", userId=" + userId + ", orderDate=" + orderDate + ", totalAmount="
				+ totalAmount + ", user=" + user + ", orderItems=" + orderItems + "]";
	}

	
}
