package com.example.demo.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.InvLocation;
import com.example.demo.service.InvlocationService;

@CrossOrigin(origins = "*")
@RestController
public class InvLocationController {

	@Autowired
	private InvlocationService invLocation;
	
	
	@GetMapping("/inventory/location/{location}/{status}")
	public List<InvLocation> getLocationInventory(@PathVariable int location, @PathVariable String status){
		System.out.println("Status--->" + status);
		return invLocation.getLocInventory(location, status);
	}
	
	
	
}
