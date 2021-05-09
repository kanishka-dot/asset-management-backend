package com.example.demo.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.UserLog;
import com.example.demo.service.UserLogService;

@RestController
@CrossOrigin(origins = "*")
public class UserLogController {

	@Autowired
	UserLogService userLogService;
	
	
	@PostMapping("/save/userLog")
	public UserLog saveUserLog(@RequestBody UserLog userLog) {
		return userLogService.saveUserLog(userLog);
	}
	
	@GetMapping("/get/userLog")
	public List<UserLog> getUserLog() {
		return  userLogService.getUserLog();
	}
	
	
}
