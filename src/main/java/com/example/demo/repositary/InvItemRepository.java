package com.example.demo.repositary;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.InvItem;

public interface InvItemRepository extends JpaRepository<InvItem, Integer> {

	InvItem findByitemcode(String itemcode);
	List<InvItem> findByStatusAndType(String status, String type);
	
	
	@Transactional
	@Query(value = "select count(*) from itemmaster where status = 'active'" , nativeQuery = true)
	Integer getActiveItemCount();
	
	

	
}
