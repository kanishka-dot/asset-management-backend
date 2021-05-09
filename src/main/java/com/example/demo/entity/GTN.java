package com.example.demo.entity;



import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import javax.persistence.Table;

@Entity
@Table(name="inv_doc_gtn_inout")

public class GTN  {


	@EmbeddedId
	private GtnPK gtnPK;
	
	
	@Column(name="serialno")
	private String serialno;
	@Column(name="frmloc")
	private Integer frmloc;
	@Column(name="toloc")
	private Integer toloc;
	@Column(name="remark")
	private String remark;
	@Column(name="refno")
	private String refno;
	@Column(name="status")
	private String status;
	@Column(name="app_by")
	private String app_by;
	@Column(name="app_date")
	private String app_date;
	@Column(name="mod_by")
	private String mod_by;
	@Column(name="mod_date")
	private String mod_date;
	@Column(name="cre_by")
	private String cre_by;
	@Column(name="cre_date")
	private String cre_date;
	

	

	public GtnPK getGtnPK() {
		return gtnPK;
	}
	public void setGtnPK(GtnPK gtnPK) {
		this.gtnPK = gtnPK;
	}
	public String getSerialno() {
		return serialno;
	}
	public void setSerialno(String serialno) {
		this.serialno = serialno;
	}
	public Integer getFrmloc() {
		return frmloc;
	}
	public void setFrmloc(Integer frmloc) {
		this.frmloc = frmloc;
	}
	public Integer getToloc() {
		return toloc;
	}
	public void setToloc(Integer toloc) {
		this.toloc = toloc;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getRefno() {
		return refno;
	}
	public void setRefno(String refno) {
		this.refno = refno;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getApp_by() {
		return app_by;
	}
	public void setApp_by(String app_by) {
		this.app_by = app_by;
	}
	public String getApp_date() {
		return app_date;
	}
	public void setApp_date(String app_date) {
		this.app_date = app_date;
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
		return "GTN [gtnPK=" + gtnPK + ", serialno=" + serialno + ", frmloc=" + frmloc + ", toloc=" + toloc
				+ ", remark=" + remark + ", refno=" + refno + ", status=" + status + ", app_by=" + app_by
				+ ", app_date=" + app_date + ", mod_by=" + mod_by + ", mod_date=" + mod_date + ", cre_by=" + cre_by
				+ ", cre_date=" + cre_date + "]";
	}
	
	
	
	
	
}
