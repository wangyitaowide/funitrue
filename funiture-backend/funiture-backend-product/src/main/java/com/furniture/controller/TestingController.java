package com.furniture.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestingController {
	
	@RequestMapping("/getProductItem")
    public String helloWorld(){
          return "endtest user hello world";
    }
	
}
