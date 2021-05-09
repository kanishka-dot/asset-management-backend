package com.example.demo.repositary;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.UserLog;

public interface UserLogRepositary extends JpaRepository<UserLog, Integer> {
	
List<UserLog> findByCredateOrderById(String date);
	

}
