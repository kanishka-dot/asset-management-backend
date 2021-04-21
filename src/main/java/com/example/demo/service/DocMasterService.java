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
	
	public int getSeqNum(String pra_doccode) {
		
		DocMaster docEntity = docMasterRepositary.findById(pra_doccode).orElse(null);
		
		if(docEntity != null) {
			return docEntity.getCurr_seq();
		}else {
			return 0;
		}
		
		
	}
	
	
	
	
}
