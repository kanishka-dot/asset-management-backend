package com.example.demo.entity;

import java.util.List;

import javax.persistence.EmbeddedId;

public class CompleteRepair {

	
	
	
	private Integer docno;
	private String userId;
	private String postDetCase;

	
	private List<MroItems> mroItems;
	

	public Integer getDocno() {
		return docno;
	}

	public void setDocno(Integer docno) {
		this.docno = docno;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<MroItems> getMroItems() {
		return mroItems;
	}

	public void setMroItems(List<MroItems> mroItems) {
		this.mroItems = mroItems;
	}

	public String getPostDetCase() {
		return postDetCase;
	}

	public void setPostDetCase(String postDetCase) {
		this.postDetCase = postDetCase;
	}
	
	
	
	

	
}
