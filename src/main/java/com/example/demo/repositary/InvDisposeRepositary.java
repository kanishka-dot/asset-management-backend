package com.example.demo.repositary;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.InvDispose;

public interface InvDisposeRepositary extends JpaRepository<InvDispose, Integer>{

//	List<InvDispose> findBydocno(Integer docno);
	
	
	List<InvDispose> findByInvDisposePKDocno(Integer docno);
	
	
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE inv_doc_dispose u set status='APP', app_by=?1, app_date=?2  where u.docno = ?3 ", nativeQuery = true)
	void updateGDNApproved(String app_by, String app_date, Integer docno);
	
	
	@Transactional
	@Query(value = "select  *  from inv_doc_dispose u where u.status = 'NAP' group by docno", nativeQuery = true)
	List<InvDispose> getAllAvailableGDN();	
	
	@Transactional
	@Query(value = "select  count(*)  from inv_doc_dispose u where u.status = 'EXE' ", nativeQuery = true)
	Integer getDisItemCount();	
	
}
