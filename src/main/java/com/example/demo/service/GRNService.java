package com.example.demo.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.example.demo.entity.GRN;
import com.example.demo.entity.InvLocation;
import com.example.demo.repositary.GRNRepositary;
import com.example.demo.repositary.InvLocationRepositary;

@Service
public class GRNService {

	@Autowired
	private GRNRepositary grnRepositary;

	@Autowired
	private DocMasterService docMasterService;
	
	@Autowired
	private InvLocationRepositary invLocationRepo;
	
	static LocalDate   date = LocalDate.now();

	@Transactional(rollbackFor = Exception.class)
	public ArrayList<String> saveGRN(ArrayList<GRN> grnList) {

		ArrayList<String> result = new ArrayList<String>();

		try {

			int docno = docMasterService.getDocNum("GRN");

			if (docno == 0) {
				throw new Exception("Document Master GRN Parameter not set");
			}

			for (int i = 0; i < grnList.size(); i++) {
			
				
				GRN updateGRN = grnList.get(i);

				if (!isSerialUnique(updateGRN.getSerialno())) {
					throw new Exception("Inventory Item already exsist for given serial no " + updateGRN.getSerialno());

				}
				
				updateGRN.getGrnPK().setDocno(docno);
				updateGRN.getGrnPK().setSeqno(i);
				
				grnRepositary.save(updateGRN);
			}

			docMasterService.updateDocNum("GRN");

			result.add("1");
			result.add("GRN Successfully Saved - " + docno);

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
	public ArrayList<String> approveGRN(Integer pra_docno, String user) {
		ArrayList<String> result = new ArrayList<String>();

		try {

			List<GRN> grn = grnRepositary.findByGrnPKDocno(pra_docno);

			if (grn == null) {
				throw new Exception("GRN not found");
			}

			for (int i = 0; i < grn.size(); i++) {
				InvLocation enty_invLocation = new InvLocation();
				GRN enty_grn = grn.get(i);
				
				// update grn status to approved
				enty_grn.setStatus("APP");
				enty_grn.setAuth(user);
				enty_grn.setMod_by("");
				enty_grn.setMod_date(date.toString());
			
				// create inventory item in location 
				enty_invLocation.setSerialno(enty_grn.getSerialno());
				enty_invLocation.setLoc_id(enty_grn.getGrnPK().getLocationid());
				enty_invLocation.setItemcode(enty_grn.getItmcode());
				enty_invLocation.setTemploc(100);
				enty_invLocation.setStatus("LOC");
				enty_invLocation.setMod_by("");
				enty_invLocation.setMod_date("1000-01-01");
				enty_invLocation.setCre_by(user);
				enty_invLocation.setCre_date(date.toString());
				
				invLocationRepo.save(enty_invLocation);
				
				grnRepositary.save(enty_grn);				
				
			}
			
			result.add("1");
			result.add("GRN No "+pra_docno+ " sucessfully approved");
			return result;

		} catch (Exception e) {
			e.printStackTrace();
			result.add("0");
			result.add(e.getLocalizedMessage());
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return result;
		}

	}

	public boolean isSerialUnique(String para_serialno) {

		GRN grn = grnRepositary.findBySerialno(para_serialno);

		if (grn != null) {
			return false;
		} else {
			return true;
		}

	}
	
	
	public List<GRN> getAvailableGRN(){
		
		List<GRN> grn = grnRepositary.getAllAvailableGRN(7);
		
		
		return grn;
	}
	
	
	public List<GRN> getGRN(Integer docno){
		
		List<GRN> grn = grnRepositary.findByGrnPKDocno(docno);
		
		return grn;
		
	}
	

}
