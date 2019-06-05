package com.apnidukan.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apnidukan.entity.Description;
import com.apnidukan.repository.DescriptionRepository;
import com.apnidukan.service.DescriptionService;

@Service
public class DescriptionServiceImpl implements DescriptionService{
	
	@Autowired
	DescriptionRepository descriptionRepo;
	
	@Override
	public Description saveDescription(Description description) {
		return descriptionRepo.save(description);
	}

	@Override
	public Description findById(Long descriptionid) {
		return descriptionRepo.findBydescriptionid(descriptionid);
	}

}
