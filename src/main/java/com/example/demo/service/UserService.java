package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Users;
import com.example.demo.entity.UsersPK;
import com.example.demo.repositary.UsersRepositary;

@Service
public class UserService {

	@Autowired
	private UsersRepositary userRepositary;
	

	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}

	public String createUser(Users user) {
		
		
		Users checkuser = userRepositary.findByUserPKUseridAndUserPKLocationid(user.getUserpk().getUserid(), user.getUserpk().getLocationid());
		System.out.println("Check User-->>>>"+checkuser);
		
		if(checkuser != null) {
			
			return "User Already Exsist";
			
		}
		
		String hasPWd = passwordEncoder().encode("12345678");
		
		user.setPassword(hasPWd);
		
		 userRepositary.save(user);
		 return "User Sucessfully Created";
	}

	public Users findUsersByUseridLocationid(String userid, Integer locationid) {
		
		
		Users user = userRepositary.findByUserPKUseridAndUserPKLocationid(userid, locationid);
		if (user == null) {
			return null;
		} else {
			return user;
		}

	}

//	public List<Users> findByuserid(String userid) {
//		return userRepositary.findByuserid(userid);
//
//	}

	public String updateUser(Users user) {
		Users nowUser = userRepositary.findByUserPKUseridAndUserPKLocationid(user.getUserpk().getUserid(),user.getUserpk().getLocationid());
		UsersPK userPk = new UsersPK();
		
//		userRepositary.updateUser(user.getName(),user.getNic(),user.getStatus(), user.getRoleid(), user.getMod_by(),nowUser.getMod_date(),nowUser.getUserid(),nowUser.getLocationid());
		
		userPk.setUserid(user.getUserpk().getUserid());
		userPk.setLocationid(user.getUserpk().getLocationid());
		
		nowUser.setUserpk(userPk);
		nowUser.setName(user.getName());
		nowUser.setNic(user.getNic());
		nowUser.setStatus(user.getStatus());
		nowUser.setRoleid(user.getRoleid());
		nowUser.setMod_by(user.getMod_by());
		nowUser.setMod_date(user.getMod_date());
//		nowUser.setCre_by(user.getCre_by());
//		nowUser.setCre_date(user.getCre_date());
		userRepositary.save(nowUser);

		return "Sucessfully User " + user.getUserpk().getUserid() + " Updated";
	}

}
