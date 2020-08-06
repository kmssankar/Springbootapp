package com.cts.airline.reservation.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cts.airline.reservation.entities.User;

public interface UserRepository  extends JpaRepository<User, Integer>{

	@Query("Select u from User u where u.userName = ?1")
	public Optional<User> getUserByUserName(String username);
	
}
