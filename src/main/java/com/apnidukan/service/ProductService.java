package com.apnidukan.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.apnidukan.entity.Product;

@Service
public interface ProductService {
	Product findById(long productid);
	List<Product> findByBrandId(long brandid);
}
