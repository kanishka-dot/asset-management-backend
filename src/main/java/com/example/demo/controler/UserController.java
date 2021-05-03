package com.example.demo.controler;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Users;
import com.example.demo.service.UserService;


@RestController
@CrossOrigin(origins = "*")
public class UserController {

	@Autowired
	private UserService userService;
	
	
//	@GetMapping("/user/getuser/{userid}")
//	public List<Users> findByuserid(@PathVariable String userid) {
//		return userService.findByuserid(userid);
//	}
//	
	
	@GetMapping("/user/getuser/{locationid}/{userid}")
	public Users findByuserbyIDAndLocation(@PathVariable Integer locationid,@PathVariable String userid) {
		return userService.findUsersByUseridLocationid(userid, locationid);
	}
	
	@PostMapping("/user/createuser")
	public String createUser(@RequestBody Users user) {
		return userService.createUser(user);
	}
	
	@PostMapping("/user/updateuser")
	public String updateUser(@RequestBody Users user) {
		return userService.updateUser(user);
	}
}
