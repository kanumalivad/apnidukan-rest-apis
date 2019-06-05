package com.apnidukan.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Otp {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name="emailid")
	private String emailid;
	
	@Column(name="otp")
	private String otp;
	
	@Column(name="expiry_date")
	private Timestamp expiry_date;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmailId() {
		return emailid;
	}
	public void setEmailId(String emailId) {
		this.emailid = emailId;
	}
	public String getOTP() {
		return otp;
	}
	public void setOTP(String OTP) {
		this.otp = OTP;
	}
	public Timestamp getExpiry_date() {
		return expiry_date;
	}
	public void setExpiry_date(Timestamp expiry_date) {
		this.expiry_date = expiry_date;
	}
}
