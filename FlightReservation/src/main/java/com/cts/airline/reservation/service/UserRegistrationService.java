package com.cts.airline.reservation.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cts.airline.reservation.entities.Role;
import com.cts.airline.reservation.entities.User;
import com.cts.airline.reservation.models.RegisterUser;
import com.cts.airline.reservation.repository.RoleRepository;
import com.cts.airline.reservation.repository.UserRepository;

@Service
public class UserRegistrationService {
	@Autowired 
	UserRepository userRepository;
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	public boolean registerUsertoDB(RegisterUser regUser) {
		if(checkUserExistence(regUser.getUserName())){
		User user = new User();
		user.setUserName(regUser.getUserName());
		user.setFirstName(regUser.getFirstName());
		user.setLastName(regUser.getLastName());
		user.setEmailId(regUser.getEmail());
		user.setPhoneNo(regUser.getPhoneNo());
		user.setPassword(bCryptPasswordEncoder.encode(regUser.getPassword()));
		Role role = roleRepository.getRolebyName("ROLE_USER").get();
		Set<Role> roleset = new HashSet<>();
		roleset.add(role);
		user.setRoles(roleset);
		userRepository.save(user);
		return true;
		}else {
			return false;
		}
	}
	
	public boolean checkUserExistence (String userName) {
		User validateUser = userRepository.getUserByUserName(userName).orElse(null);
		return (validateUser==null);
	}

}
