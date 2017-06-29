package com.hxqh.eam.model.view;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the V_MAP_STREETMAP database table.
 * 
 */
@Entity
@Table(name="V_MAP_STREETMAP")
public class VMapStreetmap implements Serializable {
	private static final long serialVersionUID = 1L;

	private Object mapx;

	private Object mapy;

	@Id
	private Object name;

	private Object openstreetmapid;

	@Column(name="\"TYPE\"")
	private String type;

	public VMapStreetmap() {
	}

	public Object getMapx() {
		return this.mapx;
	}

	public void setMapx(Object mapx) {
		this.mapx = mapx;
	}

	public Object getMapy() {
		return this.mapy;
	}

	public void setMapy(Object mapy) {
		this.mapy = mapy;
	}

	public Object getName() {
		return this.name;
	}

	public void setName(Object name) {
		this.name = name;
	}

	public Object getOpenstreetmapid() {
		return this.openstreetmapid;
	}

	public void setOpenstreetmapid(Object openstreetmapid) {
		this.openstreetmapid = openstreetmapid;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

}