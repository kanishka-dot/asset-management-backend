package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.DocMaster;
import com.example.demo.repositary.DocMaterRepositary;

@Service
public class DocMasterService {

	@Autowired
	private DocMaterRepositary docMasterRepositary;
	
	//getting the current document number (para document code)
	public int getDocNum(String pra_doccode) {
		
		DocMaster docEntity = docMasterRepositary.findById(pra_doccode).orElse(null);
		
		
		
		if(docEntity != null) {
			
			
			return docEntity.getCurr_seq();
		}else {
			return 0;
		}
		
		
	}
	
	//updating current document number by one (para document code)
	public int updateDocNum(String pra_doccode) {
		
		DocMaster docEntity = docMasterRepositary.findById(pra_doccode).orElse(null);
		
		if(docEntity != null) {
			int cur_seq =  docEntity.getCurr_seq();
			
			docEntity.setCurr_seq(cur_seq+1);
			
			docMasterRepositary.save(docEntity);
			return 1;
			
		}else {
			return 0;
		}
		
		
	}
	
	
	
	
}
