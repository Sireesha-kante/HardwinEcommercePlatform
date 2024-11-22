package com.example.ecommerce.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;

import com.example.ecommerce.dto.CartItemDto;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Orders")
public class Orders {
	@Id
	@Column(name="orderId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long orderId;
	@Column(name="userId")
	private long userId;
	@Column(name="orderDate")
	private LocalDate orderDate;
	@Column(name="totalAmount")
	private Double totalAmount;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="userName")
	private User user;

	@OneToMany(mappedBy = "orders", cascade = CascadeType.ALL)
	private List<OrderItems> orderItems;
	
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Orders(long orderId, long userId, LocalDate orderDate, Double totalAmount, User user,
			List<OrderItems> orderItems) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
		this.user = user;
		this.orderItems = orderItems;
	}

	public Orders(long userId, List<CartItemDto> cartItem, double amount) {
		this.userId=userId;
		this.orderItems=cartItem.stream().map(item ->{
		OrderItems orderitems=new OrderItems();
		orderitems.setProductId(item.getProductId());
		orderitems.setProductName(item.getProductName());
		orderitems.setQuantity(item.getQuantity());
		orderitems.setPrice(item.getPrice());
		orderitems.setOrders(this);
		return orderitems;}).toList();
		this.totalAmount=amount;
		this.orderDate = LocalDate.now();
		
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

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
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
		return "Orders [orderId=" + orderId + ", userId=" + userId + ", orderDate=" + orderDate + ", totalAmount="
				+ totalAmount + ", user=" + user + ", orderItems=" + orderItems + "]";
	}

	
	

	
}

