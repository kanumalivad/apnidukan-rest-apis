package com.apnidukan.controller;

import java.util.Objects;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apnidukan.entity.User;
import com.apnidukan.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import org.apache.commons.codec.binary.Base64;

import com.apnidukan.util.Constants;
import com.apnidukan.util.OTP;
@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/data", method = RequestMethod.GET)
	public String getdata()
	{
		String data="<table border=1><tr><td>kanu</td></tr></table>";
		return data;
	}
	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public User getUser(@PathVariable long userId)
	{
		return userService.findById(userId);
	}
	@RequestMapping(value = "/loggeduser", method = RequestMethod.POST)
	public User getLoggedInUser(@RequestBody JsonNode  token)
	{
		User u=null;
		try
		{
			 String[] split_string = token.get("token").toString().split("\\.");
		        String base64EncodedHeader = split_string[0];
		        String base64EncodedBody = split_string[1];
		        String base64EncodedSignature = split_string[2];

		        Base64 base64Url = new Base64(true);
		        String header = new String(base64Url.decode(base64EncodedHeader));
		        
		        String body = new String(base64Url.decode(base64EncodedBody));
		        JSONObject jsonObj = new JSONObject(body);
		         
		        JSONObject user = new JSONObject(jsonObj.get("user").toString());	       
		        u= userService.findByEmailid(user.get("emailid").toString());
		     
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return u;
	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<String> login(@RequestBody User loginUser) 
	{
		ResponseEntity<String> response=null;
		try
		{
			User u=userService.findByEmailid(loginUser.getEmailid());
			JSONObject userJson = new JSONObject();
			if(u!=null)
			{
				System.out.println(u.getPassword()+"="+loginUser.getPassword());
				if(u.getPassword().equals(loginUser.getPassword()))
				{
					userJson.put("status","true");
					userJson.put("msg","Login Sucessfulll...!!!");
					userJson.put("email",loginUser.getEmailid());
					userJson.put("password", loginUser.getPassword());
					userJson.put("token",userService.login(loginUser));
					System.out.println(userService.login(loginUser));
				}
				else
				{
					userJson.put("status","false");
					userJson.put("msg","Wrong Password...!!!");
				}
			}
			else
			{
				userJson.put("status","false");
				userJson.put("msg","User not Registered...!!!");
			}
			
			response = new ResponseEntity<>(userJson.toString(),HttpStatus.OK);
		}
		catch(JsonProcessingException e)
		{ 
			response=new ResponseEntity<>(e.toString(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}
	
	@RequestMapping(value = "/setPassword", method = RequestMethod.POST)
	public ResponseEntity<String> setPassword(@RequestBody User user) {
		ResponseEntity<String> response=null;
		try
		{
			userService.save(user);
			JSONObject userJson = new JSONObject();
			userJson.put("status", "true");
			userJson.put("token",userService.login(user));
			response = new ResponseEntity<>(userJson.toString(),HttpStatus.OK);
		}
		catch(JsonProcessingException e)
		{ 
			response=new ResponseEntity<>(e.toString(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
		
	}
	
	 @RequestMapping(value = "/**",method = RequestMethod.OPTIONS)
	    public ResponseEntity handle() {
		 System.out.println("Option request...");
	        return new ResponseEntity(HttpStatus.OK);
	    }
	
}
