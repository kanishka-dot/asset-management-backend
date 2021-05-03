package com.example.demo.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "inv_doc_master")
public class DocMaster {
	
	@Id
	@Column(name = "doc_code")
	private String doc_code;
	@Column(name = "doc_name")
	private String doc_name;
	@Column(name = "incr_by")
	private Integer incr_by;
	@Column(name = "curr_seq")
	private Integer curr_seq;
	
	
	public String getDoc_code() {
		return doc_code;
	}
	public void setDoc_code(String doc_code) {
		this.doc_code = doc_code;
	}
	public String getDoc_name() {
		return doc_name;
	}
	public void setDoc_name(String doc_name) {
		this.doc_name = doc_name;
	}
	public Integer getIncr_by() {
		return incr_by;
	}
	public void setIncr_by(Integer incr_by) {
		this.incr_by = incr_by;
	}
	public Integer getCurr_seq() {
		return curr_seq;
	}
	public void setCurr_seq(Integer curr_seq) {
		this.curr_seq = curr_seq;
	}
	
	
	

}
