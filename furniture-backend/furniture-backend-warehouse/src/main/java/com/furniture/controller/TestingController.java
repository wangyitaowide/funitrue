package com.furniture.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.furniture.entity.Warehouse;
import com.furniture.service.WarehouseService;

@RestController
public class TestingController {
	
	@Autowired
	WarehouseService warehouseService;
	
	@GetMapping(value = "/findById",produces = MediaType.APPLICATION_JSON_VALUE)
    public Warehouse findById(){
          return warehouseService.findById(1L);
    }
	
	@GetMapping(value = "/add",produces = MediaType.APPLICATION_JSON_VALUE)
    public Integer add() throws Exception{
		Warehouse warehouse = new Warehouse();
		warehouse.setName("ff");
		warehouse.setSize(44);
		Integer result = warehouseService.add(warehouse);
//		throw new Exception();
		return result;
    }
}
