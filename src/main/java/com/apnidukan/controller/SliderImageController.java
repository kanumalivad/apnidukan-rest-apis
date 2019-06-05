package com.apnidukan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apnidukan.entity.SliderImages;
import com.apnidukan.entity.User;
import com.apnidukan.service.SliderImagesService;
import com.fasterxml.jackson.databind.JsonNode;

@CrossOrigin
@RestController
@RequestMapping("/slider")
public class SliderImageController {
	@Autowired
	SliderImagesService sliderService;
	
	@RequestMapping(value = "/getImages", method = RequestMethod.GET)
	public List<SliderImages> getImg()
	{
		return sliderService.getimg();
	}
}
