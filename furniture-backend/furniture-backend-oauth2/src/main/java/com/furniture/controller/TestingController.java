package com.furniture.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.furniture.entity.User;
import com.furniture.service.UserService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@RestController
public class TestingController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/hello")
    public String hello(){
		return "heelo";
    }
	
	@RequestMapping("/helloTest")
    public String helloTest(){
		return "heeloTest";
    }
	
	@RequestMapping("/information")
    public Object infomation(Authentication authentication, HttpServletRequest request){
		String header = request.getHeader("Authorization");
		String token = header.substring(header.indexOf("bearer")+7);//正常情况下包含一个空格
		Claims body = Jwts.parser().setSigningKey("xxxx").parseClaimsJws(token).getBody();//获取jwt中内容
		return authentication.getPrincipal();
    }
	
	@RequestMapping("/findUser")
    public User findUser(){
		User u = new User();
		u.setName("1");
		u.setPassword("1");
		User findUser = userService.findUser(u);
		return findUser;
    }
	
}
