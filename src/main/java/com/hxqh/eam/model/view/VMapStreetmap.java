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

	private String mapx;

	private String mapy;

	@Id
	private String name;

	private String openstreetmapid;

	@Column(name="\"TYPE\"")
	private String type;

	public VMapStreetmap() {
	}

	public String getMapx() {
		return mapx;
	}

	public void setMapx(String mapx) {
		this.mapx = mapx;
	}

	public String getMapy() {
		return mapy;
	}

	public void setMapy(String mapy) {
		this.mapy = mapy;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOpenstreetmapid() {
		return openstreetmapid;
	}

	public void setOpenstreetmapid(String openstreetmapid) {
		this.openstreetmapid = openstreetmapid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}