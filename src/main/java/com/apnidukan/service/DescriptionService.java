package com.apnidukan.service;

import org.springframework.stereotype.Service;

import com.apnidukan.entity.Description;

@Service
public interface DescriptionService {
	Description saveDescription(Description description);
	Description findById(Long descriptionid);
}
