package com.furniture.dao;

import org.springframework.stereotype.Repository;

import com.furniture.entity.Warehouse;

@Repository
public interface WarehouseRepository {
	
	Warehouse findById(Long id);
	
	Integer add(Warehouse warehouse);

}
