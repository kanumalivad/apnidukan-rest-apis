package com.apnidukan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apnidukan.entity.Description;
import com.apnidukan.service.DescriptionService;
import com.apnidukan.service.ProductService;

@CrossOrigin
@RestController
@RequestMapping("/description")
public class DescriptionController {
	@Autowired
	private DescriptionService descriptionService;
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="/addDescription",method=RequestMethod.POST)
	public Description addDescription(@RequestBody Description description) {
		return descriptionService.saveDescription(description);		
	}
	
	@RequestMapping(value="/findDescriptioinByProductId/{productid}",method=RequestMethod.GET)
	public Description findByDescriptionId(@PathVariable Long productid) {
		return descriptionService.findById(productService.findById(productid).getDescriptionid());		
	}
}
