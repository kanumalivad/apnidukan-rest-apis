package com.apnidukan.serviceImpl;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.apnidukan.service.EmailNotificationService;
import com.apnidukan.util.EmailTemplates;


@Service
public class EmailNotificationServiceImpl implements EmailNotificationService {

	@Value("${spring.mail.username}")
	private String username;
	
	@Value("${spring.mail.password}")
	private String password;
	
	@Override
	public void sendEmail(String to,String text[],String mailType) {
		Properties props = new Properties();
	     props.put("mail.smtp.host", "smtp.gmail.com");    
	     props.put("mail.smtp.socketFactory.port", "465");    
	     props.put("mail.smtp.socketFactory.class",    
	               "javax.net.ssl.SSLSocketFactory");    
	     props.put("mail.smtp.auth", "true");    
	     props.put("mail.smtp.port", "465");    
	     
	 
	     Session session = Session.getInstance(props,
    	     new javax.mail.Authenticator() {
    	        protected PasswordAuthentication getPasswordAuthentication() {
    	           return new PasswordAuthentication(username, password);
    	        }
    	 });
	     try
	     {
		     Message msg=EmailTemplates.getMailTemplate(session, text, mailType);
		     msg.setRecipients(Message.RecipientType.TO,
		    	        InternetAddress.parse(to));
		     
		     Transport.send(msg);
	     }
	     catch(Exception e)
	     {
	    	 System.out.println("couldn't send mail ahiya"+e);
	     }
	}
}
