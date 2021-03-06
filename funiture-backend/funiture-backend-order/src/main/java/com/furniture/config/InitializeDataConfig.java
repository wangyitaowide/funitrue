package com.furniture.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.furniture.service.OrderService;

/**
 * 
 * @author TaoWang
 * 初始化数据三种方式：
 *	实现CommandLineRunner接口
 *	实现InitializingBean接口
 *	在需要初始化的方法上加上@PostConstruct注解
 *InitializingBean先于@PostConstruct先于CommandLineRunner
 */
@Component
public class InitializeDataConfig implements CommandLineRunner {
	
	@Autowired
	OrderService orderService;

	@Override
	public void run(String... args) throws Exception {
		orderService.createTable();
//		userService.insert();
	}

}
