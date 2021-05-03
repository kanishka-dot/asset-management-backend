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



	@Autowired
	private GRNRepositary grnRepositary;

	@Autowired
	private DocMasterService docMasterService;

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

				updateGRN.getGrnPk().setDocno(docno);
				updateGRN.getGrnPk().setSeqno(i);

				grnRepositary.save(updateGRN);
			}

			docMasterService.updateDocNum("GRN");
			
			
			result.add("1");
			result.add("GRN Successfully Saved - "+ docno);
			
			
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

}
