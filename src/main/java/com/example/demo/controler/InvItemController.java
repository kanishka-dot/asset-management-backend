package com.example.demo.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.InvItem;

import com.example.demo.service.InvItemService;

@RestController
public class InvItemController {

	@Autowired
	private InvItemService invitemservice;

	
	
	
	
	@PostMapping("/createitem")
	public InvItem createInvItem(@RequestBody InvItem invitem) {
		return invitemservice.createInvItem(invitem);
	}
	
	@GetMapping("/getitem/{itemcode}")
	public InvItem getInvItem(Integer itemcode) {
		return invitemservice.getInvItemById(itemcode);
	}
	

	
	@GetMapping("/getitems")
	public List<InvItem> getAllInvItem() {
		return invitemservice.getAllInvItem();
	}
	

	
	
}
