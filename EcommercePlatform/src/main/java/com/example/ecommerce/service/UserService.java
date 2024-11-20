package com.example.ecommerce.service;

import java.util.List;
import com.example.ecommerce.exception.ResourceNotFound;
import java.util.Optional;
import java.util.function.Function;

import com.example.ecommerce.exception.AlreadyExistException;
import com.example.ecommerce.exception.ResourceNotFound;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.dto.UserDto;
import com.example.ecommerce.entities.User;
import com.example.ecommerce.request.CreateUser;
import com.example.ecommerce.request.UpdateUser;

import lombok.RequiredArgsConstructor;
import com.example.ecommerce.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService  {
	@Autowired
	 private UserRepository userRepo;

	@Override
	public User createUser(CreateUser createUser) {
		if(userRepo.existsByuserEmail(createUser.getUserEmail()))
		{
			throw new AlreadyExistException("User with email " + createUser.getUserEmail() + "already exist");
		}
		
		User user = new User();
	    user.setUserEmail(createUser.getUserEmail());
	    user.setUserName(createUser.getUserName());
	    user.setPassword(createUser.getPassword());
	    return userRepo.save(user);
		
	}
	@Override
	public User updateUser(UpdateUser updateUser, long userId) {
		return userRepo.findById(userId).map( user->{
							user.setUserName(updateUser.getUserName());
							   user.setUserEmail(updateUser.getUserEmail());
							   user.setPassword(updateUser.getPassword());
							 return userRepo.save(user);
							   
						}).orElseThrow(()->new ResourceNotFound("user not found"));
	}

	@Override
	public void deleteUser(long userId) {
		userRepo.findById(userId).ifPresentOrElse(userRepo::delete,()->new ResourceNotFound("user not found") );
	}

	@Override
	public User findByUser(User user ,long userId) {

		return userRepo.findById(userId)
					   .orElseThrow(() -> new AlreadyExistException("User with email " +user.getUserEmail() + "notfound"));
	
	}

	@Override
	public List<User> findAll() {
		
		return userRepo.findAll();
		
	}

	@Override
	public UserDto convertUserToDTO(User user) {
		UserDto userDto = new UserDto();
        userDto.setUserId(user.getUserId());
        userDto.setUserName(user.getUserName());
        userDto.setUserEmail(user.getUserEmail());
        userDto.setPassword(user.getPassword());
        return userDto;
	}

	
}
