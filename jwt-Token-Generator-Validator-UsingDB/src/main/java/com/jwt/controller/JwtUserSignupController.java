package com.jwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.entity.UserEntity;
import com.jwt.service.JwtUserDetailsService;


@RestController
public class JwtUserSignupController {

	@Autowired
	private JwtUserDetailsService jwtUserDetailsService;
	
	@PostMapping(value = "/signup")
	public ResponseEntity<?> saveUser(@RequestBody UserEntity user) throws Exception {
		System.out.println("user :::"+user.getPassword());
		return ResponseEntity.ok(jwtUserDetailsService.save(user));
	}
}
