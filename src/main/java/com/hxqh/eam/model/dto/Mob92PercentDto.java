package com.hxqh.eam.model.dto;

public class Mob92PercentDto  {

	private Double greennum;

	private String id;

	private Double orangenum;

	private Double rednum;

	public Mob92PercentDto() {
	}

	public Mob92PercentDto(Double greennum, String id, Double orangenum, Double rednum) {
		this.greennum = greennum;
		this.id = id;
		this.orangenum = orangenum;
		this.rednum = rednum;
	}

	public Double getGreennum() {
		return greennum;
	}

	public void setGreennum(Double greennum) {
		this.greennum = greennum;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Double getOrangenum() {
		return orangenum;
	}

	public void setOrangenum(Double orangenum) {
		this.orangenum = orangenum;
	}

	public Double getRednum() {
		return rednum;
	}

	public void setRednum(Double rednum) {
		this.rednum = rednum;
	}
}