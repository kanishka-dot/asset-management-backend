package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Users;
import com.example.demo.repositary.UsersRepositary;

@Service
public class UserService {

	@Autowired
	private UsersRepositary userRepositary;

	public String createUser(Users user) {
		Users checkuser = userRepositary.findByuseridAndLocationid(user.getUserid(), user.getLocationid());
		if(checkuser != null) {
			
			return "User Already Exsist";
			
		}
		
		 userRepositary.save(user);
		 return "User Sucessfully Created";
	}

	public Users findByuseridAndLocationid(String userid, Integer locationid) {
		Users user = userRepositary.findByuseridAndLocationid(userid, locationid);
		if (user == null) {
			return null;
		} else {
			return user;
		}

	}

	public List<Users> findByuserid(String userid) {
		return userRepositary.findByuserid(userid);

	}

	public String updateUser(Users user) {
		Users nowUser = userRepositary.findByuseridAndLocationid(user.getUserid(),user.getLocationid());
		
		
		userRepositary.updateUser(user.getName(),user.getNic(),user.getStatus(), user.getRoleid(), user.getMod_by(),nowUser.getMod_date(),nowUser.getUserid(),nowUser.getLocationid());
		
		
		
//		nowUser.setName(user.getName());
//		nowUser.setNic(user.getNic());
//		nowUser.setStatus(user.getStatus());
//		nowUser.setRoleid(user.getRoleid());
//		nowUser.setMod_by(user.getMod_by());
//		nowUser.setMod_date(user.getCre_date());
//		nowUser.setCre_by(user.getCre_by());
//		nowUser.setCre_date(user.getCre_date());
//		userRepositary.save(nowUser);

		return "Sucessfully User " + user.getUserid() + " Updated";
	}

}
