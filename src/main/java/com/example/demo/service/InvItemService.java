package com.example.demo.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.InvItem;
import com.example.demo.repositary.InvItemRepository;

@Service
public class InvItemService {

	@Autowired
	private InvItemRepository invRepositary;
	
	public InvItem createInvItem(InvItem invitem) {
		return invRepositary.save(invitem);
	}
	
	public InvItem getInvItemById(String itemcode) {
		return invRepositary.findByitemcode(itemcode);
	}
	

	public List<InvItem> getAllInvItem() {
		return invRepositary.findAll();
	}
	

	
}
