package com.furniture.dao;

import org.springframework.stereotype.Repository;

import com.furniture.entity.Product;

@Repository
public interface ProductRepository {
	
	Product findById(Long id);

}
