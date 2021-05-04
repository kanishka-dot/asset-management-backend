package com.example.demo.controler;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.UserAuth;
import com.example.demo.service.UserAuthenticationService;


@RestController
@CrossOrigin(origins = "*")
public class UserLoginController {

	@Autowired
	UserAuthenticationService userAuthenticationService;
	
	
	@PostMapping("/login")
	public HashMap<String,String> userLogInCredential(@RequestBody UserAuth userAuth){


		return userAuthenticationService.validateUser(userAuth);
		
		
	}
	
	@PostMapping("/change_password/{locationid}/{userId}/{currentpwd}/{newpwd}")
	public ArrayList<String> userLogInCredential(@PathVariable Integer locationid,@PathVariable String userId, @PathVariable String currentpwd, @PathVariable String newpwd ){


		return userAuthenticationService.changePassword(userId, locationid, currentpwd, newpwd);
		
		
	}
	
	
}
