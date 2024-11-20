package com.example.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.dto.UserDto;
import com.example.ecommerce.entities.User;
import com.example.ecommerce.request.CreateUser;
import com.example.ecommerce.request.UpdateUser;
import com.example.ecommerce.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping("/createUser")
	public User  insertUser(@RequestBody CreateUser createUser )
	{
		return userService.createUser(createUser);
	}

	@PutMapping("/updateUser")
	public User updateUser(@RequestBody UpdateUser updateUser,@RequestParam long userId)
	{
		return userService.updateUser(updateUser, userId);
	}
	@DeleteMapping("/deleteUser")
	private void deleteUser(@RequestParam long userId)
	{
		 userService.deleteUser(userId);
	}
	
	@GetMapping("/getUserById")
	private User getUser(@RequestBody User user, @RequestParam long userId)
	{
		return userService.findByUser(user, userId);
	}
	
	@GetMapping("/getUsers")
	private List<User> getUser()
	{
		return userService.findAll();
	}
	
	
}
