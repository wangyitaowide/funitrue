package com.furniture.dao;

import org.springframework.stereotype.Repository;

import com.furniture.entity.User;

@Repository
public interface UserRepository {
	
	User findUserByName(String name);
	
	User findUser(User user);
	
}
