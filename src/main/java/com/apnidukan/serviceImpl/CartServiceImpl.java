package com.apnidukan.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apnidukan.entity.Cart;
import com.apnidukan.repository.CartRepository;
import com.apnidukan.service.CartService;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository cartRepo;
	
	@Override
	public Cart save(Cart cart) {
		return cartRepo.save(cart);
	}
	
	@Override
	public List<Cart> findCartByUserId(Long userid) {
		return cartRepo.findCartByuserid(userid);
	}

	@Override
	public List<Cart> findCartSizeByUserId(Long userid) {
		return cartRepo.findCartSizeByuserid(userid);
	}

	@Override
	public void deleteByUserid(long uid) {
		cartRepo.deleteByUid(uid);
		
	}


}
