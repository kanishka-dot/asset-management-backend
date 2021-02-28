package com.example.demo.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name="itemmaster")
public class InvItem {

	@Id
	@Column(name="itemcode")
	private String itemcode;
	@Column(name="itemname")
	private String itemname;
	@Column(name="itemdesc")
	private String itemdesc;
	@Column(name="depriciation")
	private Double depriciation;
	@Column(name="itemgroup")
	private String itemgroup;
	@Column(name="supplierid")
	private String supplierid;
	@Column(name="status")
	private String status;
	
	
	
	public InvItem() {
		
	}
	@Override
	public String toString() {
		return "InvItem [ itemcode=" + itemcode + ", itemname=" + itemname + ", itemdesc="
				+ itemdesc + ", depriciation=" + depriciation + ", itemgroup=" + itemgroup + ", supplierid="
				+ supplierid + ", status=" + status + "]";
	}

	public String getItemcode() {
		return itemcode;
	}
	public void setItemcode(String itemcode) {
		this.itemcode = itemcode;
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public String getItemdesc() {
		return itemdesc;
	}
	public void setItemdesc(String itemdesc) {
		this.itemdesc = itemdesc;
	}
	public Double getDepriciation() {
		return depriciation;
	}
	public void setDepriciation(Double depriciation) {
		this.depriciation = depriciation;
	}
	public String getItemgroup() {
		return itemgroup;
	}
	public void setItemgroup(String itemgroup) {
		this.itemgroup = itemgroup;
	}
	public String getSupplierid() {
		return supplierid;
	}
	public void setSupplierid(String supplierid) {
		this.supplierid = supplierid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
