package com.spring.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.security.CustomerDTO;
import com.spring.security.CustomerRepo;

@RestController
public class LoginController {

	@Autowired
	CustomerRepo customerRepo;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@PostMapping("/register")
	public ResponseEntity<String> login(@RequestBody CustomerDTO customer){
		customer.setPwd(passwordEncoder.encode(customer.getPwd()));
		customerRepo.save(customer);
		
		return ResponseEntity.ok("Registration successfully!");
	}
}
