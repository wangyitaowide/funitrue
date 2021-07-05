package com.furniture.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.furniture.dao.UserRepository;
import com.furniture.entity.User;
import com.furniture.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public User findUser(User user) {
		return userRepository.findUser(user);
	}

	@Override
	public User findUserByName(String name) {
		return userRepository.findUserByName(name);
	}

}
