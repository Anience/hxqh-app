package com.hxqh.eam.model.view;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the V_MOB_92 database table.
 * 
 */
@Entity
@Table(name="V_MOB_92")
public class VMob92 implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private BigDecimal greennum;

	private String id;

	private BigDecimal orangenum;

	private BigDecimal rednum;

	public VMob92() {
	}

	public VMob92(BigDecimal greennum, String id, BigDecimal orangenum, BigDecimal rednum) {
		this.greennum = greennum;
		this.id = id;
		this.orangenum = orangenum;
		this.rednum = rednum;
	}

	public BigDecimal getGreennum() {
		return this.greennum;
	}

	public void setGreennum(BigDecimal greennum) {
		this.greennum = greennum;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BigDecimal getOrangenum() {
		return this.orangenum;
	}

	public void setOrangenum(BigDecimal orangenum) {
		this.orangenum = orangenum;
	}

	public BigDecimal getRednum() {
		return this.rednum;
	}

	public void setRednum(BigDecimal rednum) {
		this.rednum = rednum;
	}

}