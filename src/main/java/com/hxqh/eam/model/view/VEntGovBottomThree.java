package com.hxqh.eam.model.view;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the V_ENT_GOV_BOTTOM_THREE database table.
 * 
 */
@Entity
@Table(name="V_ENT_GOV_BOTTOM_THREE")
public class VEntGovBottomThree implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="\"COUNT\"")
	private BigDecimal count;

	private String da;

	@Id
	private String name;

	public VEntGovBottomThree() {
	}

	public BigDecimal getCount() {
		return this.count;
	}

	public void setCount(BigDecimal count) {
		this.count = count;
	}

	public String getDa() {
		return this.da;
	}

	public void setDa(String da) {
		this.da = da;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}