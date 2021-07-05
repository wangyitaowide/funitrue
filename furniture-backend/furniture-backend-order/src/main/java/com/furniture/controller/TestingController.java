package com.furniture.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.furniture.callMethod.ProductFeignCall;
import com.furniture.callMethod.WarehouseFeignCall;

import io.seata.spring.annotation.GlobalTransactional;

@RestController
public class TestingController {
	
	@Autowired
	ProductFeignCall productFeignCall;
	
	@Autowired
	WarehouseFeignCall warehouseFeignCall;
	
	@RequestMapping("/hello")
    public String hello(){
		return "heelo";
    }
	
	//使用feign方式调用服务,fegin集成了ribbon,整合了Hystrix
	@RequestMapping("/getProductItem")
    public String helloFeign(){
		return productFeignCall.feignCall(null);
    }
	
	@GlobalTransactional(timeoutMills = 300000, name = "my_test_tx_group")
	@RequestMapping("/add")
    public void add(){
		productFeignCall.add();
		warehouseFeignCall.add();
    }
}
