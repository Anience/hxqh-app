package com.hxqh.eam.model.view;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the V_MAP_NEIGHBOUR database table.
 * 
 */
@Entity
@Table(name="V_MAP_NEIGHBOUR")
public class VMapNeighbour implements Serializable {
	private static final long serialVersionUID = 1L;

	private String linecolor;

	private Object neighbourx;

	private Object neighboury;

	@Id
	private Object nodex;

	private Object nodey;

	public VMapNeighbour() {
	}

	public String getLinecolor() {
		return this.linecolor;
	}

	public void setLinecolor(String linecolor) {
		this.linecolor = linecolor;
	}

	public Object getNeighbourx() {
		return this.neighbourx;
	}

	public void setNeighbourx(Object neighbourx) {
		this.neighbourx = neighbourx;
	}

	public Object getNeighboury() {
		return this.neighboury;
	}

	public void setNeighboury(Object neighboury) {
		this.neighboury = neighboury;
	}

	public Object getNodex() {
		return this.nodex;
	}

	public void setNodex(Object nodex) {
		this.nodex = nodex;
	}

	public Object getNodey() {
		return this.nodey;
	}

	public void setNodey(Object nodey) {
		this.nodey = nodey;
	}

}