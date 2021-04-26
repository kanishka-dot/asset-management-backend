package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.example.demo.entity.GRN;
import com.example.demo.repositary.GRNRepositary;

@Service
public class GRNService {
	
	private String returnval = "";
	
	

	private String getReturnval() {
		return returnval;
	}



	@Autowired
	private GRNRepositary grnRepositary;

	@Autowired
	private DocMasterService docMasterService;

	@Transactional(rollbackFor = Exception.class)
	public String saveGRN(ArrayList<GRN> grnList) {

		try {

			int docno = docMasterService.getDocNum("GRN");
			
			if(docno == 0) {
				returnval = "UNSUCCESS GRN PARA NOT SET";
				throw new Exception("Document Master GRN Parameter not set");
			}

			for (int i = 0; i < grnList.size(); i++) {

				GRN updateGRN = grnList.get(i);

				if (!isSerialUnique(updateGRN.getSerialno())) {
					returnval = "UNSUCCESS SERIAL DUPLICATE "+updateGRN.getSerialno();
					throw new Exception("Grn Serial number duplicate "+updateGRN.getSerialno());
					
				}

				updateGRN.setDocno(docno);
				updateGRN.setSeqno(i);
				grnRepositary.save(updateGRN);
			}

			docMasterService.updateDocNum("GRN");
			returnval = "GRN CREATE SUCESSFULL";
			return getReturnval();
		} catch (Exception e) {
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return getReturnval();
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

}
