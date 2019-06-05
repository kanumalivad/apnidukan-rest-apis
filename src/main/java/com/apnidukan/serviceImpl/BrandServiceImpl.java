package com.apnidukan.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apnidukan.entity.Brand;
import com.apnidukan.repository.BrandRepository;
import com.apnidukan.service.BrandService;

@Service
public class BrandServiceImpl implements BrandService {
	
	@Autowired
	private BrandRepository brandRepo;
	
	@Override
	public Brand findByBrandName(String brandname) {
		return brandRepo.findByBrandname(brandname);
	}
}
