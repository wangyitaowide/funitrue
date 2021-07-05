package com.furniture.config.testing;

import java.util.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class TestJwt {

	public void createJwt() {
		//创建token
		String key = "xxxx";
		//创建jwtBuilder对象
		//设置过期时间
		long exp = System.currentTimeMillis() + 60 * 1000;
		JwtBuilder signWith = Jwts.builder()
					.setId("123456")//声明标识
					.setSubject("jwt")//主体
					.setIssuedAt(new Date())//签发日期
					.signWith(SignatureAlgorithm.HS256, key)
					.setExpiration(new Date(exp))//设置过期时间
					.claim("name", "name");//增加自定义声明
		String compact = signWith.compact();//获取jwttoken
		System.out.println(compact);
		
		
		
		//解析token,获取载荷中信息
		Claims body = Jwts.parser().setSigningKey(key)
		.parseClaimsJws(compact).getBody();
		System.out.println(body.getSubject()+","+body.getId()+","+body.getIssuedAt());
		System.out.println(body.getExpiration());//获取过期时间
		System.out.println(body.get("name"));//获取自定义声明
	}
}
