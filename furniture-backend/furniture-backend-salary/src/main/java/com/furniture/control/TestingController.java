package com.furniture.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.furniture.service.SalaryService;

@RestController
public class TestingController {
	
	@Autowired
	SalaryService salaryService;
	
	@RequestMapping("/getProductItem")
    public String helloWorld(){
          return "endtest user hello world";
    }
	
	@GetMapping(value = "/setRedisString",produces = MediaType.APPLICATION_JSON_VALUE)
    public void setRedisString(){
         salaryService.setRedisString();
    }
	
	@GetMapping(value = "/getRedisString",produces = MediaType.APPLICATION_JSON_VALUE)
    public String getRedisString(){
          return salaryService.getRedisString();
    }
}
