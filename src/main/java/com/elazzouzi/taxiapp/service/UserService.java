package com.elazzouzi.taxiapp.service;

import java.util.List;

import com.elazzouzi.taxiapp.dto.UserDto;
import com.elazzouzi.taxiapp.model.User;

public interface UserService {
	
	public User registerNewUserAccount(final UserDto userDto);
	public User findByUsername(String username);
	public User findByEmail(String email);
	public List<User> findAllUsers();
}
