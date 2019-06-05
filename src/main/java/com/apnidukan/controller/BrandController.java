package com.apnidukan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apnidukan.entity.Brand;
import com.apnidukan.entity.Product;
import com.apnidukan.service.BrandService;
import com.apnidukan.service.ProductService;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/brand")
public class BrandController {
	
	@Autowired
	private BrandService brandService;
	@Autowired
	private ProductService productService;
	
//	@RequestMapping(value="/{brandname}",method=RequestMethod.GET)
//	public List<Product> getBrandByName(@PathVariable String brandname) 
//	{	
//		long id = brandService.findByBrandName(brandname).getBrandid();
//		List<Product> l = productService.findByBrandId(id);		
//		return l;
//	}
}
