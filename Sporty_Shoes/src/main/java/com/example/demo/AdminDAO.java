package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminDAO {
	
	@Autowired
	AdminRepo repo;
	
	public AdminPojo InsertAdmin(AdminPojo admin) {
		return repo.save(admin);
	}
	
	public AdminPojo findByUserPassword(String user,String password) {
		return repo.findByuserpwd(user, password);
	}	

}
