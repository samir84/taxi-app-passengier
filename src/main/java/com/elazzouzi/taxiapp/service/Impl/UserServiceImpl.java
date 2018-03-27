package com.elazzouzi.taxiapp.service.Impl;

import java.sql.Date;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.elazzouzi.taxiapp.dto.UserDto;
import com.elazzouzi.taxiapp.model.User;
import com.elazzouzi.taxiapp.repository.RoleRepository;
import com.elazzouzi.taxiapp.repository.UserRepository;
import com.elazzouzi.taxiapp.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public List<User> findAllUsers() {
		return (List<User>) userRepository.findAll();
	}

	@Override
	public User registerNewUserAccount(UserDto userDto) {
		User existing = userRepository.findByUsername(userDto.getUsername());
		if(existing != null) {
			try {
				throw new Exception("User already exsit with username!");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		User user = new User();
		user.setCreatedDate(new Date(Calendar.getInstance().getTimeInMillis()));
		user.setEmail(userDto.getEmail());
		user.setEnabled(true);
		user.setPassword(passwordEncoder.encode(userDto.getPassword()));
		user.setUsername(userDto.getUsername());
		user.setRoles(Arrays.asList(roleRepository.findByName("ROLE_USER")));
		return user;
	}

}
