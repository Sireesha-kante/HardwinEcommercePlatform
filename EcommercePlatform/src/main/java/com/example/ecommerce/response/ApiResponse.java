package com.example.ecommerce.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

public class ApiResponse {

	private String message;
	private Object data;
	public ApiResponse(String message, Object data) {
		super();
		this.message = message;
		this.data = data;
	}
	public ApiResponse() {
		super();
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "ApiResponse [message=" + message + ", data=" + data + "]";
	}
	
	
	
   
}
