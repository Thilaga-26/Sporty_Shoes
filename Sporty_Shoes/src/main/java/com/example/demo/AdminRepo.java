package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AdminRepo extends JpaRepository<AdminPojo, Integer> {
	
	@Query("select a from AdminPojo a where a.user=?1 and a.password=?2")
	public AdminPojo findByuserpwd(String user,String password);

}
