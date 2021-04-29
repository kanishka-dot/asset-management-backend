package com.example.demo.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.example.demo.entity.InvDispose;
import com.example.demo.entity.InvDisposePK;
import com.example.demo.entity.InvLocation;
import com.example.demo.repositary.InvDisposeRepositary;
import com.example.demo.repositary.InvLocationRepositary;

@Service
public class InvDisposeService {

	static LocalDate date = LocalDate.now();

	@Autowired
	DocMasterService docMasterService;

	@Autowired
	InvDisposeRepositary invDisposeRepositary;

	@Autowired
	InvLocationRepositary invLocationRepo;

	@Transactional
	public ArrayList<String> addDisposeInventory(List<InvDispose> pra_invList) {

		ArrayList<String> result = new ArrayList<String>();

		try {
			Integer docnum = docMasterService.getDocNum("GDN");

			if (docnum == 0) {
				throw new Exception("Unable to find Doc Parameter");
			}

			for (int i = 0; i < pra_invList.size(); i++) {
				InvDisposePK disposePK= new InvDisposePK();
				InvDispose enty_updateDispose = pra_invList.get(i);
				InvLocation enty_updateInvLocation = invLocationRepo.findById(enty_updateDispose.getSerialno())
						.orElse(null);

				if (enty_updateInvLocation == null) {
					throw new Exception("Unable to find inventory Item");
				}

				enty_updateDispose.setDoccode("GDN");
				
//				enty_updateDispose.setDocno(docnum);
//				enty_updateDispose.setSeq_no(i);
//				--------------------------------
				disposePK.setDocno(docnum);
				disposePK.setSeq_no(i);
//				--------------------------------
				enty_updateDispose.setInvDisposePK(disposePK);
				enty_updateDispose.setApp_date("1000-01-01");
				enty_updateDispose.setMod_date(date.toString());
				enty_updateDispose.setCre_date(date.toString());
				enty_updateDispose.setStatus("NAP");
				invDisposeRepositary.save(enty_updateDispose);

				enty_updateInvLocation.setStatus("INDIS");
				enty_updateInvLocation.setMod_by(enty_updateDispose.getCre_by());
				enty_updateInvLocation.setMod_date(date.toString());
				invLocationRepo.save(enty_updateInvLocation);

			}
			docMasterService.updateDocNum("GDN");
			result.add("1");
			result.add("Inventory items sucesfully added to dispose");

			return result;

		} catch (Exception e) {
			e.printStackTrace();
			result.add("0");
			result.add("Opps. Unable to save dispose Item.");
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return result;
		}

	}

	public ArrayList<String> approveDisposeInventory(Integer pra_docno, String pra_user) {
		ArrayList<String> result = new ArrayList<String>();
		try {

//			List<InvDispose> enty_InvDisList = invDisposeRepositary.findBydocno(pra_docno);
			List<InvDispose> enty_InvDisList = invDisposeRepositary.findByInvDisposePKDocno(pra_docno);

			for (int i = 0; i < enty_InvDisList.size(); i++) {

				InvDispose enty_singleDis = enty_InvDisList.get(i);

				InvLocation enty_invLoc = invLocationRepo.findBySerialno(enty_singleDis.getSerialno());
				enty_invLoc.setStatus("DIS");
				enty_invLoc.setMod_date(date.toString());
				enty_invLoc.setMod_by(pra_user);
				invLocationRepo.save(enty_invLoc);

			}

			invDisposeRepositary.updateGDNApproved(pra_user, date.toString(), pra_docno);
			result.add("1");
			result.add("Disposed Inventory Sucessfully Approved");

			return result;

		} catch (Exception e) {
			e.printStackTrace();
			result.add("0");
			result.add("Opps. Unable to save dispose Item.");
			return result;
		}
	}
	
	
	public List<Object> getAvailableGDN(){
		
		return invDisposeRepositary.getAllAvailableGDN();
			
		
	}
	
	
	public List<InvDispose> getGDNForDocNo(Integer docno){
		return invDisposeRepositary.findByInvDisposePKDocno(docno);
	}
	
	

}
