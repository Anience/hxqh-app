package com.hxqh.eam.model.view;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the V_HOME_IMPACT database table.
 * 
 */
@Entity
@Table(name="V_HOME_IMPACT")
public class VHomeImpact implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="IM_CL")
	private BigDecimal imCl;

	@Column(name="IM_OP")
	private BigDecimal imOp;

	@Column(name="IM_SH")
	private BigDecimal imSh;

	@Column(name="IM_SH_1")
	private BigDecimal imSh1;

	private BigDecimal imdev;

	@Id
	private String regional;

	public VHomeImpact() {
	}

	public BigDecimal getImCl() {
		return this.imCl;
	}

	public void setImCl(BigDecimal imCl) {
		this.imCl = imCl;
	}

	public BigDecimal getImOp() {
		return this.imOp;
	}

	public void setImOp(BigDecimal imOp) {
		this.imOp = imOp;
	}

	public BigDecimal getImSh() {
		return this.imSh;
	}

	public void setImSh(BigDecimal imSh) {
		this.imSh = imSh;
	}

	public BigDecimal getImSh1() {
		return this.imSh1;
	}

	public void setImSh1(BigDecimal imSh1) {
		this.imSh1 = imSh1;
	}

	public BigDecimal getImdev() {
		return this.imdev;
	}

	public void setImdev(BigDecimal imdev) {
		this.imdev = imdev;
	}

	public String getRegional() {
		return this.regional;
	}

	public void setRegional(String regional) {
		this.regional = regional;
	}

}