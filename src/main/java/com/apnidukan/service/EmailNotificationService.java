package com.apnidukan.service;

import javax.mail.Message;

import org.springframework.stereotype.Service;

@Service
public interface EmailNotificationService {
	
	public void sendEmail(String to,String text[],String mailType);
}
