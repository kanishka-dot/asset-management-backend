package com.example.demo.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.example.demo.entity.GTN;
import com.example.demo.entity.InvLocation;
import com.example.demo.repositary.GTNRepositary;
import com.example.demo.repositary.InvLocationRepositary;

@Service
public class GTNService {
	
	
	private String Str_return = "";
	
	static LocalDate   date = LocalDate.now();

	public String getStr_return() {
		return Str_return;
	}


	@Autowired
	GTNRepositary gtnRepositary;

	@Autowired
	DocMasterService docMasterService;
	
	@Autowired
	InvLocationRepositary invLocationRepositary;

	@Transactional(rollbackFor = Exception.class)
	public String saveGTN(ArrayList<GTN> gtnList) {

		try {
			
			Integer docNum = docMasterService.getDocNum("GTN");
			
			if(docNum == 0) {
				Str_return = "GTN Doc para Not set";
				throw new Exception("Unable to find doc master para for GTN");
			}
			
			for(int i = 0; i < gtnList.size(); i++  ) {
				
				GTN updateGTN = gtnList.get(i);
				
				InvLocation updateInvLocation = invLocationRepositary.findById(updateGTN.getSerialno()).orElse(null);
				
				if(updateInvLocation == null) {
					
					throw new Exception("Unable to find Inventory Item in Location");
				}
				
			
				
				updateGTN.setDoccode("GTN");
				updateGTN.setDocno(docNum);
				updateGTN.setSeq_no(i);
				updateGTN.setStatus("INTRAN");
				updateGTN.setCre_date(date.toString());
				updateGTN.setMod_date(date.toString());
				updateGTN.setApp_date("1000-01-01");
				gtnRepositary.save(updateGTN);
				
				
				updateInvLocation.setStatus("INTRAN");
				updateInvLocation.setMod_date(date.toString());
				updateInvLocation.setMod_by(updateGTN.getMod_by());
				invLocationRepositary.save(updateInvLocation);
										
				
			}
			docMasterService.updateDocNum("GTN");
			Str_return = "GTN Sucessfully Save" ;
			return Str_return;

		} catch (Exception e) {
			Str_return = "Error Occured when save GTN" ;
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();		
			return Str_return;
		}

	}
	
	
	@Transactional(rollbackFor = Exception.class)
	public String approveGTN(Integer gtnNo,  String user) {
		
		try {
			
			
			List<GTN> gtnList =  gtnRepositary.findBydocno(gtnNo);
			System.out.println(gtnList);
			if(gtnList.size() == 0) {
				
				throw new Exception("Unable to Find  GTN");
			}
			
			
			for(int i = 0; i < gtnList.size(); i++) {
				
					GTN getGtnEntity = gtnList.get(i);
					
					String itemSerial = getGtnEntity.getSerialno();
					Integer toLocation = getGtnEntity.getToloc();
					
					System.out.println("Item Serial --- >"+itemSerial);
					System.out.println("to Locatio --- >"+toLocation);
					System.out.println("before update inventory");
					invLocationRepositary.updateInvLocation(toLocation, itemSerial);
					System.out.println("After update inventory");
			}
			
			System.out.println("before gtn table");
			gtnRepositary.updateGTNApproved(user, date.toString(), gtnNo);
			
			return "GTN Sucessfully Approved";
		}catch(Exception e){
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return "GTN Approve Unsuccess";
		}
		
		
		
	}
	
	public List<Object> getAvailableGTN(Integer Str_location) {
		return gtnRepositary.getAllAvailableGTN(Str_location);
	}
	
	public List<GTN> getSelectGTN(Integer docno) {
		return gtnRepositary.findBydocno(docno);
	}
	
	

}

























