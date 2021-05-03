package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class UsersPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Column(name = "userid", nullable = false)
	private String userid;
	@Column(name="locationid",nullable = false)
	private Integer locationid;
	
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public Integer getLocationid() {
		return locationid;
	}
	public void setLocationid(Integer locationid) {
		this.locationid = locationid;
	}
	
	
	
	
	
	
}
