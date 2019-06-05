package com.apnidukan.serviceImpl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.apnidukan.entity.User;
import com.apnidukan.repository.UserRepository;
import com.apnidukan.service.UserService;
import com.apnidukan.util.Constants;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
@Service
public class UserServiceImpl implements UserService{

	private static final String USER_ID = "userId";
	private static final String USER_INFO = "userInfo";
	private static final String USER = "user";

	@Value("${jwt.token.expiry.time.millis}")
	private String tokenExpiryTime;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private ObjectMapper objectMapper;

	@Override
	public User findByEmailid(String email) {
		return userRepo.findByEmailid(email);
	}

	@Override
	public String login(User u) throws JsonProcessingException {
		
		Map<String,Object> header=new HashMap();
		header.put(USER_ID,u.getId());
		
		String payload=objectMapper.writeValueAsString(u);
		
		String JWTToken=Jwts.builder().setHeader(header).setSubject(USER_INFO).claim(USER,payload).setIssuedAt(new Date())
				.signWith(SignatureAlgorithm.HS256,Constants.JWT_TOKEN_SECRET).setExpiration(getTokenExpirationTime()).compact();		
		return JWTToken;
	}
	private Date getTokenExpirationTime() {
		long expirationTimeMillis = Long.parseLong(tokenExpiryTime);
		Date tokenExpiryDate = new Date(System.currentTimeMillis() + expirationTimeMillis);
		return tokenExpiryDate;
	}

	@Override
	public User findById(long id) {
		return userRepo.findById(id);
	}

	@Override
	public void save(User u) {
		userRepo.save(u);
	}
	
}
