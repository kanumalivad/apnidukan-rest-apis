package com.apnidukan.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.apnidukan.entity.Cart;

@Service
public interface CartService {
	Cart save(Cart cart);
	List<Cart> findCartByUserId(Long userid);
	List<Cart> findCartSizeByUserId(Long userid);
	void deleteByUserid(long uid);
}
