package com.example.demo.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "inv_doc_repair")
public class Repair {
	
	@EmbeddedId
	private RepairPK repairPK;
	
	
	private String itemcode;
	private String remark;
	private String mod_by;
	private String mod_date;
	private String cre_by;
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
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
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
		return "Repair [repairPK=" + repairPK + ", itemcode=" + itemcode + ", remark=" + remark + ", mod_by=" + mod_by
				+ ", mod_date=" + mod_date + ", cre_by=" + cre_by + ", cre_date=" + cre_date + "]";
	}
	
	
	
	


}
