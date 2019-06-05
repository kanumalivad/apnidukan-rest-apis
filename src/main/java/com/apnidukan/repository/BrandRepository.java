package com.apnidukan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apnidukan.entity.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long>
{
	Brand findByBrandname(String brandname);
}
