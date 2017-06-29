package com.hxqh.eam.model.view;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the V_MAP_MAPLINE database table.
 * 
 */
@Entity
@Table(name="V_MAP_MAPLINE")
public class VMapMapline implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String linecolor;

	public VMapMapline() {
	}

	public String getLinecolor() {
		return this.linecolor;
	}

	public void setLinecolor(String linecolor) {
		this.linecolor = linecolor;
	}

}