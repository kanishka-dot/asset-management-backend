package com.example.demo.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.InvItem;
import com.example.demo.entity.ItemGroup;
import com.example.demo.service.ItemGroupService;

@RestController
@CrossOrigin(origins = "*")
public class ItemGroupController {

	@Autowired
	private ItemGroupService itemGroupService;
	
	
	
	@PostMapping("/itemgroup/createnewitemgroup")
	public int createNewSupplier(@RequestBody ItemGroup itemgroup) {
		return itemGroupService.createNewItemGroup(itemgroup);
	}
	
	@GetMapping("/itemgroup/getitemgroups")
	public  List<ItemGroup>  getItemGroups() {
		return itemGroupService.getItemGroups();
	}
	
	
//	@GetMapping("/itemgroup/getitemgroup/{id}")
//	public ItemGroup  getSupplier(@PathVariable String id) {
//		
//		return itemGroupService.getItemGroup(id);
//	}
//	@PostMapping("/itemgroup/updateitemgroup")
//	public String updateSupplier(@RequestBody ItemGroup itemgroup) {
//		return itemGroupService.updateItemGroup(itemgroup);
//	}
//	
	
	
	
	
	
}
