package com.example.demo.controler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.CompleteRepair;
import com.example.demo.entity.Repair;
import com.example.demo.service.RepairService;


@CrossOrigin(origins = "*")
@RestController
public class RepairController {
	
	@Autowired
	RepairService repairService;
	
	
	@GetMapping("/inventory/repair/penitems/count")
	public Integer getInRepairItemsCount() {
		
		return repairService.pendRepItems();
	}
	
	
	
	
	
	
	@PostMapping("/inventory/repair/addRepaiItem")
	public ArrayList<String> saveRepairItem(@RequestBody Repair repairItem) {
		
		return repairService.saveRepairItem(repairItem);
	}
	
	
	@PostMapping("/inventory/repair/complete")
	public ArrayList<String> saveRepairComplete(@RequestBody CompleteRepair comRepair) {
		
		return repairService.completeRepairItem(comRepair);
	}
	
	@GetMapping("/inventory/repair/inrepair")
	public List<Repair> getInRepairItems() {
		
		return repairService.getInRepairItems();
	}
	
	

}
