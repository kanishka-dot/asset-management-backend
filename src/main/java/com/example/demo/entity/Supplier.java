package com.example.demo.entity;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="suppliers")
public class Supplier  {

	@Id
	@Column(name="supplierid", nullable = false)
	private String supplierid;
	@Column(name="name")
	private String name;
	@Column(name="address")
	private String address;
	@Column(name="nic")
	private String nic;
	@Column(name="status")
	private String status;
	@Column(name="remark")
	private String remark;
	@Column(name="mod_by")
	private String mod_by;
	@Column(name="mod_date")
	private Date mod_date;
	@Column(name="cre_by")
	private String cre_by;
	@Column(name="cre_date")
	private Date cre_date;

	public Supplier() {

	}

	public String getSupplierid() {
		return supplierid;
	}

	public void setSupplierid(String supplierid) {
		this.supplierid = supplierid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNic() {
		return nic;
	}

	public void setNic(String nic) {
		this.nic = nic;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public Date getMod_date() {
		return mod_date;
	}

	public void setMod_date(Date mod_date) {
		this.mod_date = mod_date;
	}

	public String getCre_by() {
		return cre_by;
	}

	public void setCre_by(String cre_by) {
		this.cre_by = cre_by;
	}

	public Date getCre_date() {
		return cre_date;
	}

	public void setCre_date(Date cre_date) {
		this.cre_date = cre_date;
	}

	@Override
	public String toString() {
		return "Supplier [supplierid=" + supplierid + ", name=" + name + ", address=" + address + ", nic=" + nic
				+ ", status=" + status + ", remark=" + remark + ", mod_by=" + mod_by + ", mod_date=" + mod_date
				+ ", cre_by=" + cre_by + ", cre_date=" + cre_date + "]";
	}
	
	
	
	
}
