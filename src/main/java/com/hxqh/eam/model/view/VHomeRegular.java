package com.hxqh.eam.model.view;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the V_HOME_REGULAR database table.
 * 
 */
@Entity
@Table(name="V_HOME_REGULAR")
public class VHomeRegular implements Serializable {
	private static final long serialVersionUID = 1L;


	@Column(name="RE_CL")
	private BigDecimal reCl;

	@Column(name="RE_OP")
	private BigDecimal reOp;

	@Column(name="RE_SH")
	private BigDecimal reSh;

	@Column(name="RE_SH_1")
	private BigDecimal reSh1;

	private BigDecimal redev;
	@Id
	private String regional;

	public VHomeRegular() {
	}

	public BigDecimal getReCl() {
		return this.reCl;
	}

	public void setReCl(BigDecimal reCl) {
		this.reCl = reCl;
	}

	public BigDecimal getReOp() {
		return this.reOp;
	}

	public void setReOp(BigDecimal reOp) {
		this.reOp = reOp;
	}

	public BigDecimal getReSh() {
		return this.reSh;
	}

	public void setReSh(BigDecimal reSh) {
		this.reSh = reSh;
	}

	public BigDecimal getReSh1() {
		return this.reSh1;
	}

	public void setReSh1(BigDecimal reSh1) {
		this.reSh1 = reSh1;
	}

	public BigDecimal getRedev() {
		return this.redev;
	}

	public void setRedev(BigDecimal redev) {
		this.redev = redev;
	}

	public String getRegional() {
		return this.regional;
	}

	public void setRegional(String regional) {
		this.regional = regional;
	}

}