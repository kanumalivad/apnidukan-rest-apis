package com.apnidukan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apnidukan.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmailid(String email);
	User findById(long id);
}
