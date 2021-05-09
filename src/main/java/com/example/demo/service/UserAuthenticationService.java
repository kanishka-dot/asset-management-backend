package com.example.demo.service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
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
import com.example.demo.entity.UserLog;
import com.example.demo.entity.Users;
import com.example.demo.repositary.LocationRepository;
import com.example.demo.repositary.RoleRepositary;
import com.example.demo.repositary.UserLogRepositary;
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

	@Autowired
	LocationRepository locRepo;
	
	@Autowired
	UserLogRepositary userLogRepo;
	
	LocalTime localTime = LocalTime.now(ZoneId.of("GMT+05:30"));
	
	static LocalDate date = LocalDate.now();
	
	

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

			if (user.getStatus().equalsIgnoreCase("inactive")) {
				throw new Exception("User Account deactivated");
			}

			System.out.println("user status ------>" + user.getStatus());

			if (userService.passwordEncoder().matches(user_auth.getPassword(), user.getPassword())) {
				Roles role = roleRepo.findById(user.getRoleid()).orElse(null);
				Locations location = locRepo.findBylocationid(user.getUserpk().getLocationid());

				if (role == null) {
					throw new Exception("User Role Not Define");
				}

				if (location == null) {
					throw new Exception("User Location Not Define");
				}
				
				UserLog newUserLog = new UserLog();
				
				newUserLog.setUsername(user.getUserpk().getUserid());
				newUserLog.setLocation(user.getUserpk().getLocationid());
				newUserLog.setAction("LOGIN");
				newUserLog.setTimestamp(date.toString() + " "+localTime);
				newUserLog.setMod_by("");
				newUserLog.setMod_date("1000-01-01");
				newUserLog.setCre_by("system");
				newUserLog.setCre_date(date.toString());
				
				userLogRepo.save(newUserLog);

				result.put("SUCCESS", "VALID USER");
				result.put("USERID", user.getUserpk().getUserid());
				result.put("LOCATION", user.getUserpk().getLocationid().toString());
				result.put("LOCATIONNAME", location.getLocationname());
				result.put("ROLE", role.getName());
				return result;
			} else {
				result.put("FAILED", "Invalid user name or Password");
				return result;

			}

		} catch (Exception e) {
			e.printStackTrace();
			result.put("FAILED", e.getMessage());
			return result;

		}

	}

	public ArrayList<String> changePassword(String pra_userid, Integer pra_locationId, String pra_currPaswd,
			String pra_newPaswd) {


		ArrayList<String> result = new ArrayList<String>();
		
		try {

			Users user = userRepo.findByUserPKUseridAndUserPKLocationid(pra_userid, pra_locationId);

			if (user == null) {
				throw new Exception("User Not Found.");
			}

			if (userService.passwordEncoder().matches(pra_currPaswd, user.getPassword())) {
				user.setPassword(userService.passwordEncoder().encode(pra_newPaswd));
				userRepo.save(user);
			} else {
				throw new Exception("Invalid Current Password.");
			}
			
			result.add("1");
			result.add("Password successfully updated");
			
			return result;

		} catch (Exception e) {
			result.add("0");
			result.add(e.getLocalizedMessage());
			return result;
		}

	}

}
