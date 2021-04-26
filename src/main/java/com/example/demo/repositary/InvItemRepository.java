package com.example.demo.repositary;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.InvItem;

public interface InvItemRepository extends JpaRepository<InvItem, Integer> {

	InvItem findByitemcode(String itemcode);
	List<InvItem> findByStatus(String status);
	
	
}
