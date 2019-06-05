package com.apnidukan.controller;

import java.sql.Timestamp;
import java.util.Date;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apnidukan.entity.Otp;
import com.apnidukan.entity.User;
import com.apnidukan.service.EmailNotificationService;
import com.apnidukan.service.OtpService;
import com.apnidukan.service.UserService;
import com.apnidukan.util.EmailTemplates;
import com.apnidukan.util.OTP;

import io.jsonwebtoken.lang.Objects;


@CrossOrigin
@RestController
@RequestMapping("/otp")
public class OtpController {
	
	@Autowired
	OtpService otpservice;
	@Autowired
	UserService userService;
	@Autowired
	EmailNotificationService emailService;
	
	@RequestMapping(value = "/generateOTP", method = RequestMethod.POST)
	public ResponseEntity<String> generateOTP(@RequestBody Otp otp)
	{
		ResponseEntity<String> response=null;
		JSONObject OTPJson = new JSONObject();

		User u =userService.findByEmailid(otp.getEmailId());
		if(u==null)
		{
			Otp o=otpservice.findByEmailid(otp.getEmailId());
			
			String otpstr=String.valueOf(OTP.getOTP(6));
			otp.setOTP(otpstr);
			Timestamp tt=new Timestamp(System.currentTimeMillis());
			otp.setExpiry_date(tt);
			if(o==null)
				otpservice.save(otp);
			else
			{
				Otp otpobj=otpservice.getOne(o.getId());
				otpobj.setEmailId(o.getEmailId());
				otpobj.setOTP(otpstr);
				Timestamp ttt=new Timestamp(System.currentTimeMillis());
				otpobj.setExpiry_date(ttt);
				
				otpservice.save(otpobj);
				
			}
			OTPJson.put("generatedOTP", "true");
			String text[]=new String[1];
			text[0]=otpstr;
			System.out.println("email for otp"+otp.getEmailId());
			emailService.sendEmail(otp.getEmailId(),text,EmailTemplates.OTPMail);
			response = new ResponseEntity(OTPJson.toString(),HttpStatus.OK);
		}
		else
		{
			OTPJson.put("generatedOTP", "false");
			OTPJson.put("msg", "Already registered...!!!");
			response = new ResponseEntity(OTPJson.toString(),HttpStatus.OK);
		}
		return response;
	}
	@RequestMapping(value = "/validateOTP", method = RequestMethod.POST)
	public ResponseEntity<String> validateOtp(@RequestBody Otp otp)
	{
		ResponseEntity<String> response=null;
		JSONObject OTPJson = new JSONObject();
		Otp o=otpservice.findByEmailid(otp.getEmailId());
		if(o.getOTP().equals(otp.getOTP()))
		{
			Timestamp t=o.getExpiry_date();
			Timestamp tt=new Timestamp(System.currentTimeMillis());
			 long milliseconds = tt.getTime() - t.getTime();
			 int seconds = (int) milliseconds / 1000;
			 int minutes = (seconds % 3600) / 60;
			
			 if(minutes<1)
				OTPJson.put("status", "true");
			else
			{
				OTPJson.put("status", "false");
				OTPJson.put("msg", "OTP expired...!!!");
			}
			response=new ResponseEntity(OTPJson.toString(),HttpStatus.OK);
		}
		else
		{
			OTPJson.put("status", "Wrong OTP...!!!");
			response = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}
}
