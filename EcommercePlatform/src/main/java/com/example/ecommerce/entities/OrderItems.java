package com.example.ecommerce.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "OrderItems")
public class OrderItems {
	@Id
	@Column(name="orderItemId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long orderItemId;
	@Column(name="productId")
	private  long  productId;
	@Column(name="productName")
	private String productName;
	
	@Column(name="quantity")
	private double quantity;
	
	@Column(name="price")
	private double price;
	
	@ManyToOne
	@JoinColumn(name="orderId", nullable=false)
	private Orders orders;
	
	public OrderItems() {
		// TODO Auto-generated constructor stub
	}

	public OrderItems(long orderItemId, long productId, String productName, double quantity, double price,
			Orders orders) {
		super();
		this.orderItemId = orderItemId;
		this.productId = productId;
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
		this.orders = orders;
	}

	public long getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(long orderItemId) {
		this.orderItemId = orderItemId;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "OrderItems [orderItemId=" + orderItemId + ", productId=" + productId + ", productName=" + productName
				+ ", quantity=" + quantity + ", price=" + price + ", orders=" + orders + "]";
	}

	
	

}
