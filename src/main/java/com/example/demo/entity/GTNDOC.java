package com.example.demo.entity;

import javax.persistence.Column;

public class GTNDOC {
	
	
	@Column(name="docno")
	private Integer docno;
	@Column(name="frmloc")
	private Integer frmloc;
	@Column(name="refno")
	private String refno;
	
	
	public Integer getDocno() {
		return docno;
	}
	public void setDocno(Integer docno) {
		this.docno = docno;
	}
	public Integer getFrmloc() {
		return frmloc;
	}
	public void setFrmloc(Integer frmloc) {
		this.frmloc = frmloc;
	}
	public String getRefno() {
		return refno;
	}
	public void setRefno(String refno) {
		this.refno = refno;
	}
	@Override
	public String toString() {
		return "GTNDOC [docno=" + docno + ", frmloc=" + frmloc + ", refno=" + refno + "]";
	}
	
	
	
	
	
}
