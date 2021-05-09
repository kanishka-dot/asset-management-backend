package com.example.demo.repositary;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.InvLocation;

public interface InvLocationRepositary extends JpaRepository<InvLocation, String> {

	
	List<InvLocation> findByTemplocAndStatus(Integer locid, String status);
	InvLocation findBySerialno(String serialno);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE inv_location u set status='LOC' where u.serialno = ?1 ", nativeQuery = true)
	void updateInvLocation(String serialno);
	
	
}
