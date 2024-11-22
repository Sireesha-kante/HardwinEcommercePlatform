package com.example.ecommerce.dto;

public class CartItemDto {

	private long productId;
	private long userId;
    private long categoryId;
    private String productName;
    private int quantity;
    private double price;
    private double totalPrice;
    public CartItemDto() {
		// TODO Auto-generated constructor stub
	}

	public CartItemDto(long productId, long userId, long categoryId, String productName, int quantity, double price,
			double totalPrice) {
		super();
		this.productId = productId;
		this.userId = userId;
		this.categoryId = categoryId;
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
		this.totalPrice = totalPrice;
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

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
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
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "CartItemDto [productId=" + productId + ", categoryId=" + categoryId + ", productName=" + productName
				+ ", quantity=" + quantity + ", price=" + price + ", totalPrice=" + totalPrice + "userId=" + userId+"]";
	}
	

}
