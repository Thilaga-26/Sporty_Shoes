package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepo extends JpaRepository<BankPojo, Integer> {
	
	

}
