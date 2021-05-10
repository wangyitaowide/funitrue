package com.furniture.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.furniture.entity.Product;
import com.furniture.service.ProductService;

@RestController
public class TestingController {
	
	@Autowired
	ProductService productService;
	
	@RequestMapping("/getProductItem")
    public String helloWorld(){
          return "endtest user hello world";
    }
	
	@GetMapping(value = "/findById",produces = MediaType.APPLICATION_JSON_VALUE)
    public Product findById(){
          return productService.findById(1L);
    }
}
