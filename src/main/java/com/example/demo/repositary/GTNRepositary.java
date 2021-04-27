package com.example.demo.repositary;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.GTN;

public interface GTNRepositary extends JpaRepository<GTN, Integer> {

	List<GTN> findBydocno(Integer docno);
	
	List<GTN> findByTolocAndStatus(Integer toloc, String status);
	
	@Transactional
	@Modifying
	@Query(value = "SELECT distinct(docno),toloc,refno FROM inv_doc_gtn_inout u WHERE u.doccode = 'GTN' and u.toloc = ?1 and u.status = 'INTRAN' ", nativeQuery = true)
	List<Object> getAllAvailableGTN(Integer toloc);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE inv_doc_gtn_inout u set status='TRD', app_by=?1, app_date=?2  where u.docno = ?3 ", nativeQuery = true)
	void updateGTNApproved(String app_by, String app_date, Integer docno);
	
}
