package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class GtnPK implements Serializable{

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name="docno")
	private Integer docno;
	@Column(name="seq_no")
	private Integer seq_no;
	@Column(name="doccode")
	private String doccode;
	@Column(name="itemcode")
	private String itemcode;
	
	
	public Integer getDocno() {
		return docno;
	}
	public void setDocno(Integer docno) {
		this.docno = docno;
	}
	public Integer getSeq_no() {
		return seq_no;
	}
	public void setSeq_no(Integer seq_no) {
		this.seq_no = seq_no;
	}
	public String getDoccode() {
		return doccode;
	}
	public void setDoccode(String doccode) {
		this.doccode = doccode;
	}
	public String getItemcode() {
		return itemcode;
	}
	public void setItemcode(String itemcode) {
		this.itemcode = itemcode;
	}
	
	
	
	
	
	
}
