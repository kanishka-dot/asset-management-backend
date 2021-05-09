package com.example.demo.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.example.demo.entity.CompleteRepair;
import com.example.demo.entity.InvLocation;
import com.example.demo.entity.MRO;
import com.example.demo.entity.MroItems;
import com.example.demo.entity.MroPK;
import com.example.demo.entity.Repair;
import com.example.demo.repositary.InvLocationRepositary;
import com.example.demo.repositary.MroRepositary;
import com.example.demo.repositary.RepairRepositary;

@Service
public class RepairService {

	static LocalDate date = LocalDate.now();
	
	@Autowired
	DocMasterService docMasterService;

	@Autowired
	RepairRepositary repairRepositary;

	@Autowired
	InvLocationRepositary invLocationRepositary;

	@Autowired
	MroRepositary mroRepositary;
	
	
	public Integer pendRepItems() {
		return repairRepositary.getPenRepItems();
	}
	
	
	public List<Repair> getInRepairItems(){
		
		return repairRepositary.findByStatus("INREP");
		
	}
	
	

	@Transactional(rollbackFor = Exception.class)
	public ArrayList<String> saveRepairItem(Repair repair) {

		ArrayList<String> result = new ArrayList<String>();
		
		

		try {

			int docno = docMasterService.getDocNum("RNR");

			if (docno == 0) {
				throw new Exception("Document Master RNR Parameter not set");
			}

			repair.getRepairPK().setDoccode("RNR");
			repair.getRepairPK().setDocno(docno);
			repair.setStatus("INREP");

			InvLocation InvLoc = invLocationRepositary.findBySerialno(repair.getRepairPK().getSerialno());

			if (InvLoc == null) {
				throw new Exception("Inventory Item not found in inventory location");
			}

			InvLoc.setStatus("INREP");

			invLocationRepositary.save(InvLoc);
			repairRepositary.save(repair);

			docMasterService.updateDocNum("RNR");

			result.add("1");
			result.add("Repair Item Added - " + docno);

			return result;

		} catch (Exception e) {

			e.printStackTrace();
			result.add("0");
			result.add(e.getLocalizedMessage());
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return result;

		}

	}

	@Transactional(rollbackFor = Exception.class)
	public ArrayList<String> completeRepairItem(CompleteRepair comRepair) {

		ArrayList<String> result = new ArrayList<String>();

		try {

			List<MroItems> mroList = comRepair.getMroItems();
			
			Repair updateRepair = repairRepositary.findByRepairPKDocno(comRepair.getDocno());
			
			
			
			if(updateRepair == null) {
				throw new Exception("Repair Note Raise for "+ comRepair.getDocno()+ " not found");
			}
			
			InvLocation invLoc = invLocationRepositary.findBySerialno(updateRepair.getRepairPK().getSerialno());
			
			if(invLoc == null) {
				throw new Exception("Inventory Item not found in inventory location - "+updateRepair.getRepairPK().getSerialno());
			}
			
				
			
			
			int docnoMro = docMasterService.getDocNum("MROOUT");
			
			if (docnoMro == 0) {
				throw new Exception("Document Master MROOUT Parameter not set");
			}

			if (mroList.size() > 0) {
				
				
			
				for (int i = 0; i < mroList.size(); i++) {
			
					MRO updateMro = new MRO(); 
					MroItems mroEntyItem = mroList.get(i);
					
					updateMro.getMroPK().setDoc_code("MROOUT");
					updateMro.getMroPK().setDoc_no(docnoMro);
					updateMro.getMroPK().setSeq_no(i);
					updateMro.getMroPK().setItem_code(mroEntyItem.getMroItem());
					updateMro.setQty(mroEntyItem.getQty() * -1);
					updateMro.setRemark("Added to Repair Item - "+ updateRepair.getRepairPK().getSerialno());
					updateMro.setMod_by("");
					updateMro.setMod_date("1000-01-01");
					updateMro.setCre_by(comRepair.getUserId());
					updateMro.setCre_date(date.toString());
					
					
					
					mroRepositary.save(updateMro);
				}
				
				docMasterService.updateDocNum("MROOUT");
			}
			
		
			
			
			
			// Update inventory location table
			
			invLoc.setStatus("LOC");
			invLocationRepositary.save(invLoc);
			
			//------------------------------------
			
			updateRepair.setPost_det_caus(comRepair.getPostDetCase());
			updateRepair.setSrc_doccode("MROOUT");
			updateRepair.setSrc_docno(docnoMro);
			updateRepair.setStatus("complete");
			updateRepair.setMod_by(comRepair.getUserId());
			updateRepair.setMod_date(date.toString());
			
			repairRepositary.save(updateRepair);
			
			result.add("1");
			result.add("Completed Repair Item Sucessfully Saved");
			
			return result;

		} catch (Exception e) {

			e.printStackTrace();
			result.add("0");
			result.add(e.getLocalizedMessage());
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return result;

		}

	}

}
