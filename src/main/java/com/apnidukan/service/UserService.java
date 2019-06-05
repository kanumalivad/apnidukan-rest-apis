package com.apnidukan.service;

import org.springframework.stereotype.Service;

import com.apnidukan.entity.User;
import com.fasterxml.jackson.core.JsonProcessingException;

@Service
public interface UserService {
	User findByEmailid(String email);
	User findById(long id);
	String login(User u) throws JsonProcessingException;
	void save(User u);
}
