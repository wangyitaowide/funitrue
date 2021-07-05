package com.furniture.service;

import com.furniture.entity.Product;

public interface ProductService {

	Product findById(Long id);
	
	Integer add(Product product);
}
