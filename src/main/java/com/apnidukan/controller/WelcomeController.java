package com.apnidukan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class WelcomeController {
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String welcomeMessage()
	{
		return "Welcome to ApniDukan.com";
	}
}
