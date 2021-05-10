package com.furniture.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.furniture.entity.Warehouse;
import com.furniture.service.WarehouseService;

import io.seata.spring.annotation.GlobalTransactional;

@RestController
public class TestingController {
	
	@Autowired
	WarehouseService warehouseService;
	
	@GlobalTransactional
	@GetMapping(value = "/findById",produces = MediaType.APPLICATION_JSON_VALUE)
    public Warehouse findById(){
          return warehouseService.findById(1L);
    }
}
