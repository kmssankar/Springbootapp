package com.cts.airline.reservation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.cts.airline.reservation.entities.User;
import com.cts.airline.reservation.repository.UserRepository;
import com.cts.airline.reservation.security.AppUserDetails;

@Service
public class AppUserInfoService {
	
	@Autowired
	UserRepository userRepository;
	

	public String getLoggedInUser() {
		String username;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof AppUserDetails) {
			 username = ((AppUserDetails) principal).getUsername();
		} else {
			 username = principal.toString();
		}
		return username;
	}
	
	public User getLoggedInUserObj() {
		String username;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof AppUserDetails) {
			 username = ((AppUserDetails) principal).getUsername();
		} else {
			 username = principal.toString();
		}
		User user = userRepository.getUserByUserName(username).get();
		return user;
	}
}
