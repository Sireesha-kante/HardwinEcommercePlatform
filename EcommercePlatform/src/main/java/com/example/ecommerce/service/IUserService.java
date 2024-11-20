package com.example.ecommerce.service;

import java.util.List;

import com.example.ecommerce.dto.UserDto;
import com.example.ecommerce.entities.User;
import com.example.ecommerce.request.CreateUser;
import com.example.ecommerce.request.UpdateUser;


public interface IUserService {

	public  User createUser(CreateUser createUser );
	public User updateUser(UpdateUser updateUser, long userId);
	public void deleteUser(long userId);
	public User findByUser(User user, long userId);
	public List<User> findAll();
    public UserDto convertUserToDTO(User user);
    public List<UserDto> getconvertUser(List<User> user);
}
