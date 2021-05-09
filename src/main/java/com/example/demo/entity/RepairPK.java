package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class RepairPK implements Serializable{

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="docno")
	private Integer docno;
	 @Column(name="doccode")
	private String doccode;
	 @Column(name="serialno")
	private String serialno;
	
	
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
	public String getSerialno() {
		return serialno;
	}
	public void setSerialno(String serialno) {
		this.serialno = serialno;
	}
	
	
}
