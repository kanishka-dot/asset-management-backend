package com.example.demo.repositary;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.GRN;

public interface GRNRepositary extends JpaRepository<GRN, Integer>{

	
	GRN  findBySerialno(String serialno);
	
	
	
	
}
