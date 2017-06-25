package com.hxqh.eam.model.view;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the V_MOB_88 database table.
 * 
 */
@Entity
@Table(name="V_MOB_88")
public class VMob88 implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private String name;

	@Column(name="\"VALUE\"")
	private BigDecimal value;

	public VMob88() {
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getValue() {
		return this.value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

}