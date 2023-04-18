package com.spring.security;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<CustomerDTO, Long>{
	
	List<CustomerDTO> findByEmail(String email);

}
