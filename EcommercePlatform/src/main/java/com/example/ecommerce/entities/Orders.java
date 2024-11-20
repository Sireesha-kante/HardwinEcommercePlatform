package com.example.ecommerce.entities;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data

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
	private LocalDateTime orderDate;
	@Column(name="totalAmount")
	private Double totalAmount;
	
	@OneToMany
	@JoinColumn(name="productId")
	private List<Product> products;
	
	@ManyToOne
	@JoinColumn(name="userName")
	private User user;

	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Orders(long orderId, long userId, LocalDateTime orderDate, Double totalAmount, List<Product> products,
			User user) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
		this.products = products;
		this.user = user;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", userId=" + userId + ", orderDate=" + orderDate + ", totalAmount="
				+ totalAmount + ", products=" + products + ", user=" + user + "]";
	}


	
}

