package com.example.demo.repositary;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Repair;

public interface RepairRepositary extends JpaRepository<Repair, Integer> {


	
	Repair findByRepairPKDocno(Integer docno);
	
	List<Repair> findByStatus(String status);
	
	
	
	@Transactional
	@Query(value = "select count(*) from inv_doc_repair where status = 'INREP' " , nativeQuery = true)
	Integer getPenRepItems();
	
}
