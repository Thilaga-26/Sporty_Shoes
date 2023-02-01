package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<UserPojo, String> {
	
	@Query("select u from UserPojo u where u.Username=?1 and u.Password=?2")
	public UserPojo findByuserpwd(String username,String password);

}
