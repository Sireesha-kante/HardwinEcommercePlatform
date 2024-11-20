package com.example.ecommerce.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@lombok.Data
public class ApiResponse {

	private String Message;
	private String Data;
	public ApiResponse(String message, String data) {
		super();
		Message = message;
		Data = data;
	}
	public ApiResponse() {
		super();
	}
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
	public String getData() {
		return Data;
	}
	public void setData(String data) {
		Data = data;
	}
	@Override
	public String toString() {
		return "ApiResponse [Message=" + Message + ", Data=" + Data + "]";
	}
	
	
   
}
