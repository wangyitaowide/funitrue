package com.furniture.callMethod;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//fallback熔断器
@FeignClient(name="furniture-product",fallback=HystrixHandler.class)
public interface FeignCall {

	@RequestMapping("/getProductItem")
	public String feignCall(@RequestParam("name") String name);
}
