package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.hibernate.annotations.Formula;

@Embeddable
public class MroPK implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = "doc_code")
	private String doc_code;
	@Column(name = "doc_no")
	private Integer doc_no;
	@Column(name = "item_code")
	private String item_code;
	@Column(name = "seq_no")
	private Integer seq_no;
	
	public String getDoc_code() {
		return doc_code;
	}
	public void setDoc_code(String doc_code) {
		this.doc_code = doc_code;
	}
	public Integer getDoc_no() {
		return doc_no;
	}
	public void setDoc_no(Integer doc_no) {
		this.doc_no = doc_no;
	}
	public String getItem_code() {
		return item_code;
	}
	public void setItem_code(String item_code) {
		this.item_code = item_code;
	}
	public Integer getSeq_no() {
		return seq_no;
	}
	public void setSeq_no(Integer seq_no) {
		this.seq_no = seq_no;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

	
	
}
