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
	@Column(name="itemdesc")
	private String itemdesc;
	@Column(name="brand")
	private String brand;
	@Column(name="model")
	private String model;
	@Column(name="capacity")
	private String capacity;
	@Column(name="processor")
	private String processor;
	@Column(name="ram")
	private String ram;
	@Column(name="itemgroup")
	private String itemgroup;
	@Column(name="supplierid")
	private String supplierid;
	@Column(name="status")
	private String status;
	@Column(name="type")
	private String type;
	@Column(name="mod_by")
	private String mod_by;
	@Column(name="mod_date")
	private String mod_date;
	@Column(name="cre_by")
	private String cre_date;

	public InvItem() {
		
	}


	public String getItemcode() {
		return itemcode;
	}
	public void setItemcode(String itemcode) {
		this.itemcode = itemcode;
	}

	public String getItemdesc() {
		return itemdesc;
	}
	public void setItemdesc(String itemdesc) {
		this.itemdesc = itemdesc;
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


	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}


	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public String getCapacity() {
		return capacity;
	}


	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}


	public String getProcessor() {
		return processor;
	}


	public void setProcessor(String processor) {
		this.processor = processor;
	}


	public String getRam() {
		return ram;
	}


	public void setRam(String ram) {
		this.ram = ram;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
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


	public String getCre_date() {
		return cre_date;
	}


	public void setCre_date(String cre_date) {
		this.cre_date = cre_date;
	}


	@Override
	public String toString() {
		return "InvItem [itemcode=" + itemcode + ", itemdesc=" + itemdesc + ", brand=" + brand + ", model=" + model
				+ ", capacity=" + capacity + ", processor=" + processor + ", ram=" + ram + ", itemgroup=" + itemgroup
				+ ", supplierid=" + supplierid + ", status=" + status + ", type=" + type + ", mod_by=" + mod_by
				+ ", mod_date=" + mod_date + ", cre_date=" + cre_date + "]";
	}
	
	
	
}
