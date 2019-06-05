package com.apnidukan.repository;

import java.util.List;

import org.jboss.logging.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.apnidukan.entity.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {	
	Cart save(Cart cart);
	List<Cart> findCartByuserid(Long userid);
	List<Cart> findCartSizeByuserid(Long userid);
	
	@Query(value="delete from Cart c where c.userid = ?1")
	void deleteByUid(long userid);
}
