package com.apnidukan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apnidukan.entity.Otp;

@Repository
public interface OtpRepository extends JpaRepository<Otp, Long>{
	Otp findByEmailid(String emailid);
}
