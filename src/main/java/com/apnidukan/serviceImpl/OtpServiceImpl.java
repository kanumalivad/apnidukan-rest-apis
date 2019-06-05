package com.apnidukan.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apnidukan.entity.Otp;
import com.apnidukan.repository.OtpRepository;
import com.apnidukan.service.OtpService;

@Service
public class OtpServiceImpl implements OtpService{
	
	@Autowired
	OtpRepository otpRepo;
	
	@Override
	public void save(Otp otp) {
		otpRepo.save(otp);
	}

	@Override
	public Otp findByEmailid(String emailid) {
		return otpRepo.findByEmailid(emailid);
	}

	@Override
	public Otp getOne(long id) {
		return otpRepo.getOne(id);
	}
}
