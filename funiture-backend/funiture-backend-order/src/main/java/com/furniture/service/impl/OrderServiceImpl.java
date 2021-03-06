package com.furniture.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.furniture.dao.OrderDao;
import com.furniture.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderDao orderDao;
	
	@Override
	public void createTable() {
		orderDao.createTable();
	}

}
