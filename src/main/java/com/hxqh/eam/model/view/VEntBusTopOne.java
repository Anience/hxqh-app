package com.hxqh.eam.model.view;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the V_ENT_BUS_TOP_ONE database table.
 * 
 */
@Entity
@Table(name="V_ENT_BUS_TOP_ONE")
public class VEntBusTopOne implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="\"COUNT\"")
	private String count;

	private String da;

	@Id
	private Timestamp name;

	public VEntBusTopOne() {
	}

	public String getCount() {
		return this.count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getDa() {
		return this.da;
	}

	public void setDa(String da) {
		this.da = da;
	}

	public Timestamp getName() {
		return this.name;
	}

	public void setName(Timestamp name) {
		this.name = name;
	}

}