package com.example.demo.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "locations")
public class Locations {

	@Id
	@Column(name = "locationid", nullable = false)
	private Integer locationid;
	@Column(name = "locationname")
	private String locationname;
	@Column(name = "mod_by")
	private String mod_by;
	@Column(name = "mod_date")
	private Date mod_date;
	@Column(name = "cre_by")
	private String cre_by;
	@Column(name = "cre_date")
	private Date cre_date;

	public Integer getLocationid() {
		return locationid;
	}

	public void setLocationid(Integer locationid) {
		this.locationid = locationid;
	}

	public String getLocationname() {
		return locationname;
	}

	public void setLocationname(String locationname) {
		this.locationname = locationname;
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
		return "Locations [locationid=" + locationid + ", locationname=" + locationname + ", mod_by=" + mod_by
				+ ", mod_date=" + mod_date + ", cre_by=" + cre_by + ", cre_date=" + cre_date + "]";
	}

}
