package com.hxqh.eam.model.view;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the V_MOB_86 database table.
 * 
 */
@Entity
@Table(name="V_MOB_86")
public class VMob86 implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private String ioc1;

	private BigDecimal ioc2;

	private BigDecimal ioc3;

	private BigDecimal ioc4;

	private BigDecimal ioc5;

	private BigDecimal ioc6;

	private BigDecimal ioc7;

	public VMob86() {
	}

	public String getIoc1() {
		return this.ioc1;
	}

	public void setIoc1(String ioc1) {
		this.ioc1 = ioc1;
	}

	public BigDecimal getIoc2() {
		return this.ioc2;
	}

	public void setIoc2(BigDecimal ioc2) {
		this.ioc2 = ioc2;
	}

	public BigDecimal getIoc3() {
		return this.ioc3;
	}

	public void setIoc3(BigDecimal ioc3) {
		this.ioc3 = ioc3;
	}

	public BigDecimal getIoc4() {
		return this.ioc4;
	}

	public void setIoc4(BigDecimal ioc4) {
		this.ioc4 = ioc4;
	}

	public BigDecimal getIoc5() {
		return this.ioc5;
	}

	public void setIoc5(BigDecimal ioc5) {
		this.ioc5 = ioc5;
	}

	public BigDecimal getIoc6() {
		return this.ioc6;
	}

	public void setIoc6(BigDecimal ioc6) {
		this.ioc6 = ioc6;
	}

	public BigDecimal getIoc7() {
		return this.ioc7;
	}

	public void setIoc7(BigDecimal ioc7) {
		this.ioc7 = ioc7;
	}

}