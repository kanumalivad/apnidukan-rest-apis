package com.apnidukan.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apnidukan.entity.SliderImages;
import com.apnidukan.repository.SliderImagesRepository;
import com.apnidukan.service.SliderImagesService;

@Service
public class SliderImagesServiceImpl implements SliderImagesService{

	@Autowired
	SliderImagesRepository sliderRepo;
	@Override
	public List<SliderImages> getimg() {
		return sliderRepo.findByState("active");
	}

}
