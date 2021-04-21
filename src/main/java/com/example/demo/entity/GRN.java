package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "inv_doc_grn")
@IdClass(GRN.class)
public class GRN implements Serializable{

	@Id	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="docno")
	private Integer docno;
	@Id	
	@Column(name="doccode")
	private String doccode;
	@Id	
	@Column(name="locationid")
	private Integer locationid;
	@Id	
	@Column(name="seqno")
	private Integer seqno;
	@Column(name="date")
	private String auth_date;
	@Column(name="serialno")
	private String serialno;
	@Column(name="status")
	private String status;
	@Column(name="dilvryprson")
	private String dlvryprson;
	@Column(name="auth")
	private String authby;
	@Column(name="itmcode")
	private String itmcode;
	@Column(name="barcode")
	private String barcode;
	@Column(name="cost")
	private String cost;
	@Column(name="supplierid")
	private String supid;
	@Column(name="warrenty_period")
	private String wrtyprd;
	@Column(name="refno")
	private String refno;
	@Column(name="mod_by")
	private String mod_by;
	@Column(name="mod_date")
	private String mod_date;
	@Column(name="cre_by")
	private String cre_by;
	@Column(name="cre_date")
	private String cre_date;
	
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
	public Integer getLocid() {
		return locationid;
	}
	public void setLocid(Integer locid) {
		this.locationid = locid;
	}
	
	public Integer getSeqno() {
		return seqno;
	}
	public void setSeqno(Integer seqno) {
		this.seqno = seqno;
	}
	public String getAuth_date() {
		return auth_date;
	}
	public void setAuth_date(String auth_date) {
		this.auth_date = auth_date;
	}
	public String getSerialno() {
		return serialno;
	}
	public void setSerialno(String serialno) {
		this.serialno = serialno;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getDlvryprson() {
		return dlvryprson;
	}
	public void setDlvryprson(String dlvryprson) {
		this.dlvryprson = dlvryprson;
	}
	public String getWrtyprd() {
		return wrtyprd;
	}
	public void setWrtyprd(String wrtyprd) {
		this.wrtyprd = wrtyprd;
	}
	public String getAuthby() {
		return authby;
	}
	public void setAuthby(String authby) {
		this.authby = authby;
	}
	public String getItmcode() {
		return itmcode;
	}
	public void setItmcode(String itmcode) {
		this.itmcode = itmcode;
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
	public String getSupid() {
		return supid;
	}
	public void setSupid(String supid) {
		this.supid = supid;
	}
	public String getWrntyprod() {
		return wrtyprd;
	}
	public void setWrntyprod(String wrtyprd) {
		this.wrtyprd = wrtyprd;
	}
	public String getRefno() {
		return refno;
	}
	public void setRefno(String refno) {
		this.refno = refno;
	}
	public String getMod_by() {
		return mod_by;
	}
	public void setMod_by(String mod_by) {
		this.mod_by = mod_by;
	}
	
	public String getMod_date() {
		return mod_date;
	}
	public void setMod_date(String mod_date) {
		this.mod_date = mod_date;
	}
	public String getCre_by() {
		return cre_by;
	}
	public void setCre_by(String cre_by) {
		this.cre_by = cre_by;
	}
	public String getCre_date() {
		return cre_date;
	}
	public void setCre_date(String cre_date) {
		this.cre_date = cre_date;
	}
	@Override
	public String toString() {
		return "GRN [docno=" + docno + ", doccode=" + doccode + ", locid=" + locationid + ", seqno=" + seqno + ", auth_date="
				+ auth_date + ", serialno=" + serialno + ", status=" + status + ", dlvryprson=" + dlvryprson
				+ ", authby=" + authby + ", itmcode=" + itmcode + ", barcode=" + barcode + ", cost=" + cost + ", supid="
				+ supid + ", wrtyprd=" + wrtyprd + ", refno=" + refno + ", mod_by=" + mod_by + ", mod_date=" + mod_date
				+ ", cre_by=" + cre_by + ", cre_date=" + cre_date + "]";
	}

	

	
	
}
