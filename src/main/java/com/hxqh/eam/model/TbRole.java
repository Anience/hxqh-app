package com.hxqh.eam.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the TB_ROLE database table.
 * 
 */
@Entity
@Table(name="TB_ROLE")
public class TbRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TB_ROLE_ROLEID_GENERATOR",allocationSize = 1, sequenceName="SEQ_ROLE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TB_ROLE_ROLEID_GENERATOR")
	private long roleid;

	private String roledesc;

	private String rolename;

	private BigDecimal rolestatus;

	private BigDecimal sortnum;

	public TbRole() {
	}

	public long getRoleid() {
		return this.roleid;
	}

	public void setRoleid(long roleid) {
		this.roleid = roleid;
	}

	public String getRoledesc() {
		return this.roledesc;
	}

	public void setRoledesc(String roledesc) {
		this.roledesc = roledesc;
	}

	public String getRolename() {
		return this.rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public BigDecimal getRolestatus() {
		return this.rolestatus;
	}

	public void setRolestatus(BigDecimal rolestatus) {
		this.rolestatus = rolestatus;
	}

	public BigDecimal getSortnum() {
		return this.sortnum;
	}

	public void setSortnum(BigDecimal sortnum) {
		this.sortnum = sortnum;
	}

}