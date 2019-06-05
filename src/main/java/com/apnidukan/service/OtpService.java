package com.apnidukan.service;

import org.springframework.stereotype.Service;

import com.apnidukan.entity.Otp;

@Service
public interface OtpService {
	public void save(Otp otp);
	public Otp findByEmailid(String emailid);
	public Otp getOne(long id);
}
