package com.example.demo.entity;



import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class Users  {
	
	@EmbeddedId
	private UsersPK userPK;
	


	@Column(name="name")
	private String name;
	@Column(name="nic")
	private String nic;
	@Column(name="password")
	private String password;
	@Column(name="status")
	private String status;
	@Column(name="roleid")
	private Integer roleid;
	@Column(name="mod_by")
	private String mod_by;
	@Column(name="mod_date")
	private String mod_date;
	@Column(name="cre_by")
	private String cre_by;
	@Column(name="cre_date")
	private String cre_date;
	
	

	public UsersPK getUserpk() {
		return userPK;
	}
	public void setUserpk(UsersPK userpk) {
		this.userPK = userpk;
	}
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNic() {
		return nic;
	}
	public void setNic(String nic) {
		this.nic = nic;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getRoleid() {
		return roleid;
	}
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
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
		return "Users [userpk=" + userPK + ", name=" + name + ", nic=" + nic + ", password=" + password + ", status="
				+ status + ", roleid=" + roleid + ", mod_by=" + mod_by + ", mod_date=" + mod_date + ", cre_by=" + cre_by
				+ ", cre_date=" + cre_date + "]";
	}

	
	
}
