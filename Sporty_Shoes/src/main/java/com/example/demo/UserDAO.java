package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDAO {

	
	@Autowired
	UserRepo repo;
	
	public UserPojo Insert(UserPojo user) {
		return repo.save(user);
	}
	
	public List<UserPojo> getalluser(){
		return repo.findAll();
	}
	
	public UserPojo findByUserPassword(String username,String password) {
		return repo.findByuserpwd(username, password);
	}
}
