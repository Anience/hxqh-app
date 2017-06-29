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

	private String neighbourx;

	private String neighboury;

	@Id
	private String nodex;

	private String nodey;

	public VMapNeighbour() {
	}

	public String getLinecolor() {
		return linecolor;
	}

	public void setLinecolor(String linecolor) {
		this.linecolor = linecolor;
	}

	public String getNeighbourx() {
		return neighbourx;
	}

	public void setNeighbourx(String neighbourx) {
		this.neighbourx = neighbourx;
	}

	public String getNeighboury() {
		return neighboury;
	}

	public void setNeighboury(String neighboury) {
		this.neighboury = neighboury;
	}

	public String getNodex() {
		return nodex;
	}

	public void setNodex(String nodex) {
		this.nodex = nodex;
	}

	public String getNodey() {
		return nodey;
	}

	public void setNodey(String nodey) {
		this.nodey = nodey;
	}
}