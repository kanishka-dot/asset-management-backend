package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.InvLocation;
import com.example.demo.repositary.InvLocationRepositary;

@Service
public class InvlocationService {

	@Autowired
	private InvLocationRepositary inLocationRepo;
	
	public List<InvLocation> getLocInventory(Integer locid, String status){
		return inLocationRepo.findByTemplocAndStatus(locid, status);
		
	}
	
}
