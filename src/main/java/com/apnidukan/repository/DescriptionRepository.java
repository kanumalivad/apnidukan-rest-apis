package com.apnidukan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apnidukan.entity.Description;

@Repository
public interface DescriptionRepository extends JpaRepository<Description, Long> {
	Description save(Description description);
	Description findBydescriptionid(Long descriptionid);
}
