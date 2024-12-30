package com.springsecurity.springsecurity.securityservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springsecurity.springsecurity.securityException.ResourceNotFoundException;
import com.springsecurity.springsecurity.securityentity.MyUser;
import com.springsecurity.springsecurity.securityrepository.UserRepo;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		MyUser user = userRepo.findByUsername(username)
				.orElseThrow(() -> new ResourceNotFoundException("username", "user", username));
		return user;
	}

}
