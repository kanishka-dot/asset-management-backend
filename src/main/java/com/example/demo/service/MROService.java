package com.example.demo.service;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.example.demo.entity.MRO;
import com.example.demo.repositary.MroRepositary;

@Service
public class MROService {

	@Autowired
	private DocMasterService docMasterService;

	@Autowired
	private MroRepositary mroRepositary;

	@Transactional(rollbackFor = Exception.class)
	public ArrayList<String> saveMRO(ArrayList<MRO> mroList) {

		ArrayList<String> result = new ArrayList<String>();

		try {

			int docno = docMasterService.getDocNum("MROIN");

			if (docno == 0) {
				throw new Exception("Document Master MROIN Parameter not set");
			}

			for (int i = 0; i < mroList.size(); i++) {

				MRO updateMRO = mroList.get(i);

				updateMRO.getMroPK().setDoc_code("MROIN");
				updateMRO.getMroPK().setDoc_no(docno);
				updateMRO.getMroPK().setSeq_no(i);

				mroRepositary.save(updateMRO);
			}

			docMasterService.updateDocNum("MROIN");

			result.add("1");
			result.add("MRO Successfully Saved - " + docno);

			return result;

		} catch (Exception e) {
			e.printStackTrace();
			result.add("0");
			result.add(e.getLocalizedMessage());
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return result;
		}
	}

	public ArrayList<String> saveMroOUT(ArrayList<MRO> mrooutList) {

		ArrayList<String> result = new ArrayList<String>();

		try {

			int docno = docMasterService.getDocNum("MROOUT");

			if (docno == 0) {
				throw new Exception("Document Master MROOUT Parameter not set");
			}

			for (int i = 0; i < mrooutList.size(); i++) {

				MRO saveMroOut = mrooutList.get(i);

//				Integer balQty = mroRepositary.getAvailableItmQty(saveMroOut.getMroPK().getItem_code());
//				Integer issuQty = saveMroOut.getQty();
				
//			if(issuQty>balQty) {
//				
//				throw new Exception("Available balance not enough for the operation. ItemCode - "+saveMroOut.getMroPK().getItem_code());
//				
//			}
			
				saveMroOut.getMroPK().setDoc_code("MROOUT");
				saveMroOut.getMroPK().setDoc_no(docno);
				saveMroOut.getMroPK().setSeq_no(i);
				saveMroOut.setQty(saveMroOut.getQty()*-1);
			
			

				mroRepositary.save(saveMroOut);
			}

			docMasterService.updateDocNum("MROOUT");

			result.add("1");
			result.add("MRO Dispatch Successfully Saved - " + docno);

			return result;

		} catch (Exception e) {
			e.printStackTrace();
			result.add("0");
			result.add(e.getLocalizedMessage());
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return result;
		}

	}

	public Integer getAvailabelInvBal(String itmcod) {

		Integer qty = mroRepositary.getAvailableItmQty(itmcod);
		
		if(qty ==null) {
			return 0;
		}

		return qty;
	}

}
