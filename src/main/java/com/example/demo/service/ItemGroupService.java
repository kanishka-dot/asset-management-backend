package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ItemGroup;
import com.example.demo.repositary.ItemGroupRepository;

@Service
public class ItemGroupService {

	@Autowired
	private ItemGroupRepository itemGroupRepository;
	
	public int createNewItemGroup(ItemGroup itemgroup) {
		
		Optional<ItemGroup> itemGroupIsExsist =  itemGroupRepository.findById(itemgroup.getId());
		if(itemGroupIsExsist.isPresent()) {	
			System.out.println(itemGroupIsExsist);
			return 0;
		}else {
			itemGroupRepository.save(itemgroup);
			return 1;
		}
		

		
	}
	
	public List<ItemGroup> getItemGroups() {
		return itemGroupRepository.findAll();
		
	}
	
//	
//	public ItemGroup getItemGroup(String id) {
//		return itemGroupRepository.findById(id).orElse(null);
//		
//		
//	}
//	
//	
//	
//	public String updateItemGroup(ItemGroup itemgroup) {
//		ItemGroup updaingItemGroup = itemGroupRepository.findbyid(itemgroup.getId());
//
//		if (updaingItemGroup == null) {
//
//			return "Unable to Find Item Group";
//			
//		} else {
//
//			updaingItemGroup.setName(itemgroup.getName());
//			updaingItemGroup.setMod_by(itemgroup.getMod_by());
//			updaingItemGroup.setMod_date(itemgroup.getMod_date());
//			updaingItemGroup.setCre_by(itemgroup.getCre_by());
//			updaingItemGroup.setCre_date(itemgroup.getCre_date());
//			itemGroupRepository.save(updaingItemGroup);
//			return "Item Group Successfully Updated";
//
//		}
//
//	}
	
	
	
	
}
