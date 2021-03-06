package com.furniture.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.furniture.callMethod.FeignCall;

@RestController
public class TestingController {
	
	@Autowired
	FeignCall feignCall;
	
	@RequestMapping("/hello")
    public String hello(){
		return "heelo";
    }
	
	//使用feign方式调用服务,fegin集成了ribbon,整合了Hystrix
	@RequestMapping("/getProductItem")
    public String helloFeign(){
		return feignCall.feignCall(null);
    }
	
}
