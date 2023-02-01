package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BankDAO {
	
	@Autowired
	BankRepo repo;
	
	public BankPojo InsertAmount(BankPojo b) {
		return repo.save(b);
	}
	
	public List<BankPojo> getAmnt(){
		return repo.findAll();
	}

	
	

}
