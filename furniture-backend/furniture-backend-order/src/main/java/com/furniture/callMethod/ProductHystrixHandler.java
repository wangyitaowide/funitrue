package com.furniture.callMethod;

import org.springframework.stereotype.Component;

/**
 * Feign中集成Hystrix
 * @author TaoWang
 *
 */
@Component
public class ProductHystrixHandler implements ProductFeignCall {

	@Override
	public String feignCall(String name) {
		// TODO Auto-generated method stub
		return "Hystrix Hello";
	}

	@Override
	public Integer add() {
		return 0;
	}

}
