package com.furniture.service;

import com.furniture.entity.User;

public interface UserService {
	
	User findUserByName(String name);
	
	User findUser(User user);
	
}
