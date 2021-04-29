package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;

@Embeddable
public class InvDisposePK implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "docno")
	private Integer docno;
	@Column(name = "seq_no")
	private Integer seq_no;
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

	
}
