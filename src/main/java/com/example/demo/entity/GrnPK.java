package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class GRNPK implements Serializable {

	
	
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Column(name = "docno")
	private Integer docno;
	@Column(name = "doccode")
	private String doccode;
	@Column(name = "locationid")
	private Integer locationid;
	@Column(name = "seqno")
	private Integer seqno;
	
	
	public Integer getDocno() {
		return docno;
	}
	public void setDocno(Integer docno) {
		this.docno = docno;
	}
	public String getDoccode() {
		return doccode;
	}
	public void setDoccode(String doccode) {
		this.doccode = doccode;
	}
	public Integer getLocationid() {
		return locationid;
	}
	public void setLocationid(Integer locationid) {
		this.locationid = locationid;
	}
	public Integer getSeqno() {
		return seqno;
	}
	public void setSeqno(Integer seqno) {
		this.seqno = seqno;
	}
	
	
	
	
	
}
