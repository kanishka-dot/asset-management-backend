package com.example.demo.entity;



import javax.persistence.Column;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "inv_doc_repair")
public class Repair {
	
	@EmbeddedId
	private RepairPK repairPK;
	

	 @Column(name="itemcode")
	private String itemcode;
	 @Column(name="pre_det_caus")
	private String pre_det_caus;
	 @Column(name="post_det_caus")
	private String post_det_caus;
	 @Column(name="src_doccode")
	private String src_doccode;
	 @Column(name="src_docno")
	private Integer src_docno;
	 @Column(name="status")
	private String status;
	 @Column(name="mod_by")
	private String mod_by;
	 @Column(name="mod_date")
	private String mod_date;
	 @Column(name="cre_by")
	private String cre_by;
	 @Column(name="cre_date")
	private String cre_date;
	 
	 
	public RepairPK getRepairPK() {
		return repairPK;
	}
	public void setRepairPK(RepairPK repairPK) {
		this.repairPK = repairPK;
	}
	
	

	public String getItemcode() {
		return itemcode;
	}
	public void setItemcode(String itemcode) {
		this.itemcode = itemcode;
	}
	public String getPre_det_caus() {
		return pre_det_caus;
	}
	public void setPre_det_caus(String pre_det_caus) {
		this.pre_det_caus = pre_det_caus;
	}
	public String getPost_det_caus() {
		return post_det_caus;
	}
	public void setPost_det_caus(String post_det_caus) {
		this.post_det_caus = post_det_caus;
	}
	public String getSrc_doccode() {
		return src_doccode;
	}
	public void setSrc_doccode(String src_doccode) {
		this.src_doccode = src_doccode;
	}
	public Integer getSrc_docno() {
		return src_docno;
	}
	public void setSrc_docno(Integer src_docno) {
		this.src_docno = src_docno;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
		return "Repair [repairPK=" + repairPK + ", itemcode=" + itemcode + ", pre_det_caus=" + pre_det_caus
				+ ", post_det_caus=" + post_det_caus + ", src_doccode=" + src_doccode + ", src_docno=" + src_docno
				+ ", status=" + status + ", mod_by=" + mod_by + ", mod_date=" + mod_date + ", cre_by=" + cre_by
				+ ", cre_date=" + cre_date + "]";
	}

	


}
