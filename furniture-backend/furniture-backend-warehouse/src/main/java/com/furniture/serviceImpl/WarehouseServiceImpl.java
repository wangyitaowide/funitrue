package com.furniture.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.furniture.dao.WarehouseRepository;
import com.furniture.entity.Warehouse;
import com.furniture.service.WarehouseService;

@Service
public class WarehouseServiceImpl implements WarehouseService {

	@Autowired
	WarehouseRepository repository;
	
	@Override
	public Warehouse findById(Long id) {
		return repository.findById(id);
	}
	
	@Override
	public Integer add(Warehouse warehouse) {
		return repository.add(warehouse);
	}
}
