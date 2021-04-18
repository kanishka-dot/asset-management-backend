package com.example.demo.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.InvItem;

import com.example.demo.service.InvItemService;

@RestController
@CrossOrigin("*")
public class InvItemController {

	@Autowired
	private InvItemService invitemservice;

	
	
	
	
	@PostMapping("/inventory/createitem")
	public InvItem createInvItem(@RequestBody InvItem invitem) {
		return invitemservice.createInvItem(invitem);
	}
	
	@GetMapping("/inventory/getitem/{itemcode}")
	public InvItem getInvItem(Integer itemcode) {
		return invitemservice.getInvItemById(itemcode);
	}
	

	
	@GetMapping("/inventory/getitems")
	public List<InvItem> getAllInvItem() {
		return invitemservice.getAllInvItem();
	}
	

	
	
}
