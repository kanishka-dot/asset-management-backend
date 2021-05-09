package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.UserLog;
import com.example.demo.repositary.UserLogRepositary;

@Service
public class UserLogService {
	
	
	@Autowired
	UserLogRepositary userLogRepositary;
	
	static LocalDate date = LocalDate.now();
	
	
	public UserLog saveUserLog(UserLog userLog) {
		
		return userLogRepositary.save(userLog);
		
	}
	
	public List<UserLog> getUserLog() {
		return userLogRepositary.findByCredateOrderById(date.toString());
	}
	
	
	
	

}
