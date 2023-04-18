package com.spring.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.security.CustomerDTO;
import com.spring.security.CustomerRepo;

@RestController
public class UserController {
	
	@Autowired
	CustomerRepo customerRepo;
	
	@GetMapping("/greeting")
	public String greeting() {
		return "Welcome to the spring securityu!";
	}
	
	
	@GetMapping("/name")
	public String greeting(@RequestParam String name) {
		return "Welcome to the spring security! "+name;
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<CustomerDTO>> users() {
		List<CustomerDTO> cusotmerData =  customerRepo.findAll();
		System.out.println("Inside load customers");
		return ResponseEntity
                .status(HttpStatus.OK)
                .body(cusotmerData);
	}

}
