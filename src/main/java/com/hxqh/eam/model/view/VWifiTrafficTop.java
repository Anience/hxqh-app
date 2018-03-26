package com.hxqh.eam.model.view;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the V_WIFI_TRAFFIC_TOP database table.
 * 
 */
@Entity
@Table(name="V_WIFI_TRAFFIC_TOP")
public class VWifiTrafficTop implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="\"COUNT\"")
	private BigDecimal count;

	private String da;
	@Id
	private Double rn;

	private String name;

	@Column(name="AGG_TS")
	private String aggts;

	public VWifiTrafficTop() {
	}

	public VWifiTrafficTop(BigDecimal count, String da, Double rn, String name, String aggts) {
		this.count = count;
		this.da = da;
		this.rn = rn;
		this.name = name;
		this.aggts = aggts;
	}



	public Double getRn() {
		return rn;
	}

	public void setRn(Double rn) {
		this.rn = rn;
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

	public String getAggts() {
		return aggts;
	}

	public void setAggts(String aggts) {
		this.aggts = aggts;
	}
}