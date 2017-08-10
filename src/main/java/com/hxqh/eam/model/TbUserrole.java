package com.hxqh.eam.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the TB_USERROLE database table.
 * 
 */
@Entity
@Table(name="TB_USERROLE")
public class TbUserrole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TB_USERROLE_USERROLEID_GENERATOR", sequenceName="SEQ_USERROLE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TB_USERROLE_USERROLEID_GENERATOR")
	private long userroleid;

	private String id;

	private BigDecimal roleid;

	public TbUserrole() {
	}

	public TbUserrole(String id, BigDecimal roleid) {
		this.id = id;
		this.roleid = roleid;
	}

	public long getUserroleid() {
		return this.userroleid;
	}

	public void setUserroleid(long userroleid) {
		this.userroleid = userroleid;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BigDecimal getRoleid() {
		return this.roleid;
	}

	public void setRoleid(BigDecimal roleid) {
		this.roleid = roleid;
	}

}