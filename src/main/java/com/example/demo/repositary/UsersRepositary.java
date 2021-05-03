package com.example.demo.repositary;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Users;

public interface UsersRepositary extends JpaRepository<Users, String> {

//	Users findByName(String name);

	Users findByUserPKUseridAndUserPKLocationid(String userid, Integer locationid);
	
	

//	List<Users> findByuserid(String userid);

	@Transactional
	@Modifying
	@Query(value = "UPDATE users u set name =?1, nic=?2, status=?3, roleid=?4, mod_by=?5, mod_date=?6 where u.userid = ?7 and u.locationid = ?8", nativeQuery = true)
	void updateUser(String name, String nic, String status, Integer role, String mod_by, String mod_date, String userId,
			Integer locationid);
}
