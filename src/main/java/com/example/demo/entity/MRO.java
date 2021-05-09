package com.example.demo.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

import com.sun.istack.NotNull;

@Entity
@Table(name = "mro_supplies")
public class MRO {

	@EmbeddedId @NotNull
	private MroPK mroPK ;

	@Column(name = "cost")
	private Double cost;
	@Column(name = "qty")
	private Integer qty;
	@Column(name = "tot_cost")
	private Double tot_cost;
	@Column(name = "remark")
	private String remark;
	@Column(name = "supplier")
	private String supplier;
	@Column(name = "mod_by")
	private String mod_by;
	@Column(name = "mod_date")
	private String mod_date;
	@Column(name = "cre_by")
	private String cre_by;
	@Column(name = "cre_date")
	private String cre_date;

	public MRO() {
	
		this.mroPK = new MroPK();
	}

	public MroPK getMroPK() {
		return mroPK;
	}

	public void setMroPK(MroPK mroPK) {
		this.mroPK = mroPK;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

	public Double getTot_cost() {
		return tot_cost;
	}

	public void setTot_cost(Double tot_cost) {
		this.tot_cost = tot_cost;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	
	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
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
		return "MRO [mroPK=" + mroPK + ", cost=" + cost + ", qty=" + qty + ", tot_cost=" + tot_cost + ", remark="
				+ remark + ", mod_by=" + mod_by + ", mod_date=" + mod_date + ", cre_by=" + cre_by + ", cre_date="
				+ cre_date + "]";
	}

}
