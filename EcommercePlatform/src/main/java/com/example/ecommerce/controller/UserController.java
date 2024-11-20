package com.example.ecommerce.controller;

import java.util.List;

import javax.xml.crypto.Data;

import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.ecommerce.dto.UserDto;
import com.example.ecommerce.entities.User;
import com.example.ecommerce.exception.AlreadyExistException;
import com.example.ecommerce.exception.ResourceNotFound;
import com.example.ecommerce.request.CreateUser;
import com.example.ecommerce.request.UpdateUser;
import com.example.ecommerce.response.ApiResponse;
import com.example.ecommerce.service.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("${api.prefix}/users")
@RestController
public class UserController {
	@Autowired
	private final UserService userService;
	
	@PostMapping("/createUser")
	public ResponseEntity<ApiResponse>  insertUser(@RequestBody CreateUser createUser )
	{
	 try {
		 User user=userService.createUser(createUser);
		 UserDto userDto=userService.convertUserToDTO(user);
		 return ResponseEntity.ok(new ApiResponse("Sucess",userDto)); 
	 }
	 catch(AlreadyExistException ae) {
		 return ResponseEntity.status(HttpStatus.CONFLICT).body(new ApiResponse(ae.getMessage(),null) );
		 
	 }
	 
	}

	@PutMapping("/{userId}updateUser")
	public ResponseEntity<ApiResponse> updateUser(@RequestBody UpdateUser updateUser,@PathVariable long userId)
	{
		 try {
			 User user=userService.updateUser(updateUser,userId);
			 UserDto userDto=userService.convertUserToDTO(user);
			 return ResponseEntity.ok(new ApiResponse("Update Sucessful",userDto)); 
		 }
		 catch(ResourceNotFound rnf) {
			 return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(rnf.getMessage(),null) );
			 
		 }
	}
	@DeleteMapping("/{userId}deleteUser")
	private ResponseEntity<ApiResponse> deleteUser(@PathVariable long userId)
	{
		try {
			 userService.deleteUser(userId);
			 return ResponseEntity.ok(new ApiResponse("User removed from db",null));
			
		}catch (ResourceNotFound rnf) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("no data found", null));
		}
		 
	}
	
	@GetMapping("/{userId}/getuser")
	private ResponseEntity<ApiResponse> getUserById(@RequestBody User user, @PathVariable long userId)
	{
		try {
		User userbyid=userService.findByUser(user, userId);
		UserDto userDto=userService.convertUserToDTO(userbyid);
		return  ResponseEntity.ok(new ApiResponse("something", userDto));
	}catch(ResourceNotFound rnf ){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(rnf.getMessage(),null));
	}
		
	}
	
	@GetMapping("/getUsers")
	private ResponseEntity<ApiResponse> getUser()
	{
		try {
			 List<User> user=userService.findAll();
			 List<UserDto> userDto=userService.getconvertUser(user);
			 return ResponseEntity.ok(new ApiResponse("Here is the List of USERS:",userDto ));
		}catch (ResourceNotFound rnf) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("NoUser data in DB", null));
		}
	}
	
	
}
