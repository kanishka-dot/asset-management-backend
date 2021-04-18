package com.example.demo.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "item_group")
public class ItemGroup {

	@Id
	@Column(name = "id", nullable = false)
	private String id;
	@Column(name = "name")
	private String name;
	@Column(name="depriciation")
	private Double depriciation;
	@Column(name = "mod_by")
	private String mod_by;
	@Column(name = "mod_date")
	private Date mod_date;
	@Column(name = "cre_by")
	private String cre_by;
	@Column(name = "cre_date")
	private Date cre_date;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Double getDepriciation() {
		return depriciation;
	}
	public void setDepriciation(Double depriciation) {
		this.depriciation = depriciation;
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
		return "ItemGroup [id=" + id + ", name=" + name + ", depriciation=" + depriciation + ",mod_by=" + mod_by + ", mod_date=" + mod_date + ", cre_by="
				+ cre_by + ", cre_date=" + cre_date + "]";
	}
	
	

}
