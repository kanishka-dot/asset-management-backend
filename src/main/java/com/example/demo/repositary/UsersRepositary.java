package com.example.demo.repositary;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.entity.Users;

public interface UsersRepositary extends JpaRepository<Users, String> {

	Users findByName(String name);

	Users findByuseridAndLocationid(String userid, Integer locationid);

	List<Users> findByuserid(String userid);
	
	
}
