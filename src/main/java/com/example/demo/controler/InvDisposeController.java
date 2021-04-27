package com.example.demo.controler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.InvDispose;
import com.example.demo.service.InvDisposeService;

@RestController
public class InvDisposeController {
	
	@Autowired
	InvDisposeService invDisposeService;
	
	@PostMapping("/inventory/dispose/data")
	public ArrayList<String> saveDisposeinventory(@RequestBody List<InvDispose> invDispose) {
		return invDisposeService.addDisposeInventory(invDispose);
	}
	
	@PostMapping("/inventory/dispose/approve/{docno}/{user}")
	public ArrayList<String> approveDisposeinventory(@PathVariable Integer docno, @PathVariable String user) {
		return invDisposeService.approveDisposeInventory(docno, user);
	}
	
	

}
