package com.furniture.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.furniture.dao.ProductRepository;
import com.furniture.entity.Product;
import com.furniture.service.ProductService;

@Service
public class ProductServeImpl implements ProductService {

	@Autowired
	ProductRepository repository;
	
	@Override
	public Product findById(Long id) {
		
		return repository.findById(id);
	}
	
	@Transactional
	@Override
	public Integer add(Product product) {
		return repository.add(product);
	}

}
