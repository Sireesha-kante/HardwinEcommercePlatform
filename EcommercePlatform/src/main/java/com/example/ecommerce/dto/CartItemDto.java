package com.example.ecommerce.dto;

public class CartItemDto {

	private String productId;
    private String categoryId;
    private String productName;
    private int quantity;
    private double price;
    private double totalPrice;
    public CartItemDto() {
		// TODO Auto-generated constructor stub
	}
	public CartItemDto(String productId, String categoryId, String productName, int quantity, double price,
			double totalPrice) {
		super();
		this.productId = productId;
		this.categoryId = categoryId;
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
		this.totalPrice = totalPrice;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
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
				+ ", quantity=" + quantity + ", price=" + price + ", totalPrice=" + totalPrice + "]";
	}
	

}
