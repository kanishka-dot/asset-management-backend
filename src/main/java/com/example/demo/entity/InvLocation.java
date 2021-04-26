package com.example.demo.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name="inv_location")

public class InvLocation   {

	@Id
	@Column(name = "serialno")
	private String serialno;
	@Column(name = "locid")
	private Integer locid;
	@Column(name = "itemcode")
	private String itemcode;
	@Column(name = "status")
	private String status;
	@Column(name = "mod_by")
	private String mod_by;
	@Column(name = "mod_date")
	private String mod_date;
	@Column(name = "cre_by")
	private String cre_by;
	@Column(name = "cre_date")
	private String cre_date;
	
	
	public Integer getLoc_id() {
		return locid;
	}
	public void setLoc_id(Integer loc_id) {
		this.locid = loc_id;
	}
	public String getSerialno() {
		return serialno;
	}
	public void setSerialno(String serialno) {
		this.serialno = serialno;
	}
	public String getItemcode() {
		return itemcode;
	}
	public void setItemcode(String itemcode) {
		this.itemcode = itemcode;
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
		return "InvLocation [serialno=" + serialno + ", locid=" + locid + ", itemcode=" + itemcode + ", status="
				+ status + ", mod_by=" + mod_by + ", mod_date=" + mod_date + ", cre_by=" + cre_by + ", cre_date="
				+ cre_date + "]";
	}

	
	
	
}
