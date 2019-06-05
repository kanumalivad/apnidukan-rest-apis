package com.apnidukan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apnidukan.entity.Product;
import com.apnidukan.service.BrandService;
import com.apnidukan.service.ProductService;
import com.fasterxml.jackson.databind.JsonNode;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private BrandService brandService;
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="/{productid}", method=RequestMethod.GET)
	public Product getProductById(@PathVariable long productid) {
		return productService.findById(productid);
	}
	
	@RequestMapping(value="/b/{brand}",method=RequestMethod.GET)
	public List<Product> getProductByBrandId(@PathVariable String  brand) {
		
		return productService.findByBrandId(brandService.findByBrandName(brand).getBrandid());
	}
}
