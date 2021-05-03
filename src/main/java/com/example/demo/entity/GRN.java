package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "inv_doc_grn")
public class GRN {

	
	@EmbeddedId
	private GRNPK grnPk;
	
	

	@Column(name="date")
	private String date;
	@Column(name="serialno")
	private String serialno;
	@Column(name="status")
	private String status;
	@Column(name="dilvryprson")
	private String dilvryprson;
	@Column(name="auth")
	private String auth;
	@Column(name="itmcode")
	private String itmcode;
	@Column(name="barcode")
	private String barcode;
	@Column(name="cost")
	private String cost;
	@Column(name="supplierid")
	private String supplierid;
	@Column(name="warrenty_period")
	private String warrenty_period;
	@Column(name="refno")
	private String refno;
	@Column(name="mod_by")
	private String mod_by;
	@Column(name="mod_date")
	private String mod_date;
	@Column(name="cre_by")
	private String cre_by;
	@Column(name="cre_date")
	private String cre_date;

	
	
	
	
	public GRNPK getGrnPk() {
		return grnPk;
	}
	public void setGrnPk(GRNPK grnPk) {
		this.grnPk = grnPk;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getSerialno() {
		return serialno;
	}
	public void setSerialno(String serialno) {
		this.serialno = serialno;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public String getDilvryprson() {
		return dilvryprson;
	}
	public void setDilvryprson(String dilvryprson) {
		this.dilvryprson = dilvryprson;
	}
	public String getAuth() {
		return auth;
	}
	public void setAuth(String auth) {
		this.auth = auth;
	}
	public String getItmcode() {
		return itmcode;
	}
	public void setItmcode(String itmcode) {
		this.itmcode = itmcode;
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
	public String getSupplierid() {
		return supplierid;
	}
	public void setSupplierid(String supplierid) {
		this.supplierid = supplierid;
	}
	public String getWarrenty_period() {
		return warrenty_period;
	}
	public void setWarrenty_period(String warrenty_period) {
		this.warrenty_period = warrenty_period;
	}
	public String getRefno() {
		return refno;
	}
	public void setRefno(String refno) {
		this.refno = refno;
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
		return "GRN [grnPk=" + grnPk + ", date=" + date + ", serialno=" + serialno + ", status=" + status
				+ ", dilvryprson=" + dilvryprson + ", auth=" + auth + ", itmcode=" + itmcode + ", barcode=" + barcode
				+ ", cost=" + cost + ", supplierid=" + supplierid + ", warrenty_period=" + warrenty_period + ", refno="
				+ refno + ", mod_by=" + mod_by + ", mod_date=" + mod_date + ", cre_by=" + cre_by + ", cre_date="
				+ cre_date + "]";
	}
	
	
	
	
	
	
}
