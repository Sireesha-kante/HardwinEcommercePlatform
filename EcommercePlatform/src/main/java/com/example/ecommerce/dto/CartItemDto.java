package com.example.ecommerce.dto;

public class CartItemDto {

	private long productId;
	private long userId;
    private String productName;
    private int quantity;
    private double price;
    private double totalPrice;
    public CartItemDto() {
		// TODO Auto-generated constructor stub
	}
	public CartItemDto(long productId, long userId, String productName, int quantity, double price, double totalPrice) {
		super();
		this.productId = productId;
		this.userId = userId;
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
		this.totalPrice=price*quantity;
	}
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice= (price*quantity);
	}
	
	@Override
	public String toString() {
		return "CartItemDto [productId=" + productId + ", userId=" + userId + ", productName=" + productName
				+ ", quantity=" + quantity + ", price=" + price + "]";
	}



}
