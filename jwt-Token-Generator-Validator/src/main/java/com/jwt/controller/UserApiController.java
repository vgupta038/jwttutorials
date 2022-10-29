package com.jwt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserApiController {
	
	@GetMapping(value= "/hello")
	public String firstPage() {
		return "Hello World";
	}
}
