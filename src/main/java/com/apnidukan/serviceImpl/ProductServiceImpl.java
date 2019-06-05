package com.apnidukan.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apnidukan.entity.Product;
import com.apnidukan.repository.ProductRepository;
import com.apnidukan.service.ProductService;


@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepo;
	
	@Override
	public Product findById(long productid) {
		return productRepo.findById(productid);
	}

	@Override
	public List<Product> findByBrandId(long brandid) { 
		return productRepo.findByBrandid(brandid);
	}

}
