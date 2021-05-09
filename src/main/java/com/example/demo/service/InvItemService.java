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
	
	public Integer getInvItemCount() {
		return invRepositary.getActiveItemCount();
	}
	
	
	public InvItem createInvItem(InvItem invitem) {
		return invRepositary.save(invitem);
	}
	
	public InvItem getInvItemById(String itemcode) {
		return invRepositary.findByitemcode(itemcode);
	}
	

	public List<InvItem> getAllInvItem() {
		return invRepositary.findAll();
	}
	
	public List<InvItem> getAllActInvItem(String status, String type) {
		return invRepositary.findByStatusAndType(status, type);
	}
	
	public int updateItemCode(InvItem invItem) {
		InvItem updatingItemCode = invRepositary.findByitemcode(invItem.getItemcode());
		
		
		if(updatingItemCode == null) {
			return 0;
		}else {
			
			updatingItemCode.setItemgroup(invItem.getItemgroup());
			updatingItemCode.setSupplierid(invItem.getSupplierid());
			updatingItemCode.setItemdesc(invItem.getItemdesc());
			updatingItemCode.setBrand(invItem.getBrand());
			updatingItemCode.setModel(invItem.getModel());
			updatingItemCode.setProcessor(invItem.getProcessor());
			updatingItemCode.setRam(invItem.getRam());
			updatingItemCode.setCapacity(invItem.getCapacity());
			updatingItemCode.setStatus(invItem.getStatus());
			updatingItemCode.setType(invItem.getType());
			updatingItemCode.setMod_by(invItem.getMod_by());
			updatingItemCode.setMod_date(invItem.getMod_date());
			invRepositary.save(updatingItemCode);
			
			return 1;
			
		}
	}
	

	
}
