package com.example.demo.repositary;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.InvLocation;

public interface InvLocationRepositary extends JpaRepository<InvLocation, String> {

	
	List<InvLocation> findBylocidAndStatus(Integer locid, String status);
	InvLocation findBySerialno(String serialno);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE inv_location u set status='LOC', locid=?1  where u.serialno = ?2 ", nativeQuery = true)
	void updateInvLocation(Integer locid, String serialno);
	
	
}
