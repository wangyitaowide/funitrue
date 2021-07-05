package com.furniture.callMethod;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
//fallback熔断器
@FeignClient(name="furniture-warehouse",fallback=WarehouseHystrixHandler.class)
public interface WarehouseFeignCall {

	@RequestMapping("/add")
	public Integer add();
}
