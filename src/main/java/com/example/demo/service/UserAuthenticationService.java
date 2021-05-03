package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Locations;
import com.example.demo.entity.Roles;
import com.example.demo.entity.UserAuth;
import com.example.demo.entity.Users;
import com.example.demo.repositary.LocationRepository;
import com.example.demo.repositary.RoleRepositary;
import com.example.demo.repositary.UsersRepositary;

@Service
public class UserAuthenticationService {

	@Autowired
	LocationRepository locationRepo;

	@Autowired
	UsersRepositary userRepo;

	@Autowired
	UserService userService;

	@Autowired
	RoleRepositary roleRepo;

	public HashMap<String, String> validateUser(UserAuth user_auth) {

		HashMap<String, String> result = new HashMap<String, String>();

		try {

			Locations loc = locationRepo.findBylocationid(user_auth.getLocationid());

			if (loc == null) {
				throw new Exception("Invalid Location ID");
			}

			Users user = userRepo.findByUserPKUseridAndUserPKLocationid(user_auth.getUserid(),
					user_auth.getLocationid());

			if (user == null) {
				throw new Exception("User Not found For the given location");
			}
			
			if (user.getStatus() == "inactive") {
				throw new Exception("User Account deactivated");
			}

			if (userService.passwordEncoder().matches(user_auth.getPassword(), user.getPassword())) {
				Roles role = roleRepo.findById(user.getRoleid()).orElse(null);
				
				if (role == null) {
					throw new Exception("User Role Not Define");
				}

				result.put("SUCCESS", "VALID USER");
				result.put("USERID", user.getUserpk().getUserid());
				result.put("LOCATION", user.getUserpk().getLocationid().toString());
				result.put("ROLE", role.getName());
				return result;
			} else {
				result.put("FAILED", "Invalid Password");
				return result;

			}

		} catch (Exception e) {
			e.printStackTrace();
			result.put("FAILED", e.getMessage());
			return result;

		}

	}

}
