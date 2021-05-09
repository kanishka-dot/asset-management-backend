package com.example.demo.repositary;





import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.GRN;

public interface GRNRepositary extends JpaRepository<GRN, Integer>{

	
	GRN  findBySerialno(String serialno);
	
	List<GRN> findByGrnPKDocno(Integer docno);
	
	@Transactional
	@Modifying
	@Query(value = "select * from inv_doc_grn where status = 'NAP' and cre_date > curdate() + INTERVAL -?1 DAY group by docno;", nativeQuery = true)
	List<GRN> getAllAvailableGRN(Integer lead_days);
	

	
}
