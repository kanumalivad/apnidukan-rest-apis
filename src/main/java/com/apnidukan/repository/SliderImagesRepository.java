package com.apnidukan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apnidukan.entity.SliderImages;

public interface SliderImagesRepository extends JpaRepository<SliderImages, Long>{
	List<SliderImages> findByState(String state);
}
