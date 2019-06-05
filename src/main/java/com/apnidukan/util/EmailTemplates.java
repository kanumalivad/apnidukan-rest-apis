package com.apnidukan.util;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Value;

public class EmailTemplates {
	
	@Value("${spring.mail.username}")
	private static String from;
	
	public static String OTPMail="OTPType";
	public static Message getMailTemplate(Session s,String text[],String mailType) {
		Message message=null;
		try
		{
			message = new MimeMessage(s);
			message.setFrom(new InternetAddress("kanu.malivad@gmail.com"));
			if(mailType.equals(OTPMail))
			{
				message.setSubject("OTP ApniDukan.com");
				message.setText("This is your one time password "+text[0]);
			}
			
		}
		catch(Exception e)
		{
			System.out.println("could't send mail"+e);
		}
		return message;
	}
}
