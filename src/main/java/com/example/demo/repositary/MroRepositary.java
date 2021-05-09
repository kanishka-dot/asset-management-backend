package com.example.demo.repositary;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;


import com.example.demo.entity.MRO;

public interface MroRepositary extends JpaRepository<MRO, Integer>{
	
	
	@Transactional
	@Query(value = "select sum(qty) from mro_supplies where item_code = ?1 " , nativeQuery = true)
	Integer getAvailableItmQty(String itmcod);
	
	

}
