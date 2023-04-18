package com.spring.security.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.security.CustomerDTO;
import com.spring.security.CustomerRepo;


@Service
public class CustomUserService implements UserDetailsService{

	@Autowired
	CustomerRepo customerRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		String userName, password = null;
		List<GrantedAuthority> authorities = null;
		List<CustomerDTO> customers = customerRepo.findByEmail(username);
		if (customers.isEmpty()) {
			throw new UsernameNotFoundException("user name not found "+username);
		}
		userName = customers.get(0).getEmail();
		password = customers.get(0).getPwd();
		authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(customers.get(0).getRole()));
		return new User(userName, password, authorities);
	}

}
