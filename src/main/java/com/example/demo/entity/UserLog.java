package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "user_log")
public class UserLog {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "username")
	private String username;
	@Column(name = "location")
	private Integer location;
	@Column(name = "action")
	private String action;
	@Column(name = "timestamp")
	private String timestamp;
	@Column(name = "mod_by")
	private String mod_by;
	@Column(name = "mod_date")
	private String mod_date;
	@Column(name = "cre_by")
	private String cre_by;
	@Column(name = "cre_date")
	private String credate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAction() {
		return action;
	}
	
	
	
	
	
	

	public Integer getLocation() {
		return location;
	}

	public void setLocation(Integer location) {
		this.location = location;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
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
		return credate;
	}

	public void setCre_date(String credate) {
		this.credate = credate;
	}

}
