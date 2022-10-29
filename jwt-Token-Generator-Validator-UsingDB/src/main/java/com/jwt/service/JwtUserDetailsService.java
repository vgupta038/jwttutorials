package com.jwt.service;

import java.util.ArrayList;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.jwt.entity.UserEntity;
import com.jwt.repository.UserEntityRepository;


@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private UserEntityRepository userEntityRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity dbuser=userEntityRepository.findByUsername(username);
		if(Objects.isNull(dbuser)) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(dbuser.getUsername(), dbuser.getPassword(),
				new ArrayList<>());
	}
	
	public UserEntity save(UserEntity user) {
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		return userEntityRepository.save(user);
	}

}
