package com.cts.airline.reservation.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cts.airline.reservation.entities.User;
import com.cts.airline.reservation.repository.UserRepository;


@Service
public class UserDetailServiceImpl implements UserDetailsService  {

	@Autowired
	UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 User user = userRepository.getUserByUserName(username).orElse(null); 
		 if (user == null) {
	            throw new UsernameNotFoundException("Could not find user");
	        }
		 System.out.println("User : " + user.getId() + " " + user.getUserName());
		 return new AppUserDetails(user);
    }
}
