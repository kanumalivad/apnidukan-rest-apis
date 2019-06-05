package com.apnidukan.service;

import org.springframework.stereotype.Service;

import com.apnidukan.entity.Brand;

@Service
public interface BrandService {
	Brand findByBrandName(String brandname);
}
