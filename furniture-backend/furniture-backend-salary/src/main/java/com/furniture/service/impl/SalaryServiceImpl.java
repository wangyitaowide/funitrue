package com.furniture.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.furniture.service.SalaryService;
import com.furniture.utils.RedisUtils;

@Service
public class SalaryServiceImpl implements SalaryService {

	@Autowired
	RedisUtils redisUtils;
	
	@Override
	public void setRedisString() {
		redisUtils.set("stt", "1234567890");
	}

	@Override
	public String getRedisString() {
		return (String)redisUtils.get("stt");
	}

}
