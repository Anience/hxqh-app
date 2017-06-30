package com.hxqh.eam.model.view;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the V_HOME_TOTAL database table.
 * 
 */
@Entity
@Table(name="V_HOME_TOTAL")
public class VHomeTotal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String regional;


	@Column(name="TO_CL")
	private BigDecimal toCl;

	@Column(name="TO_DEV")
	private BigDecimal toDev;

	@Column(name="TO_OP")
	private BigDecimal toOp;

	@Column(name="TO_SH")
	private BigDecimal toSh;

	@Column(name="TO_SH_1")
	private BigDecimal toSh1;

	public VHomeTotal() {
	}

	public String getRegional() {
		return this.regional;
	}

	public void setRegional(String regional) {
		this.regional = regional;
	}

	public BigDecimal getToCl() {
		return this.toCl;
	}

	public void setToCl(BigDecimal toCl) {
		this.toCl = toCl;
	}

	public BigDecimal getToDev() {
		return this.toDev;
	}

	public void setToDev(BigDecimal toDev) {
		this.toDev = toDev;
	}

	public BigDecimal getToOp() {
		return this.toOp;
	}

	public void setToOp(BigDecimal toOp) {
		this.toOp = toOp;
	}

	public BigDecimal getToSh() {
		return this.toSh;
	}

	public void setToSh(BigDecimal toSh) {
		this.toSh = toSh;
	}

	public BigDecimal getToSh1() {
		return this.toSh1;
	}

	public void setToSh1(BigDecimal toSh1) {
		this.toSh1 = toSh1;
	}

}