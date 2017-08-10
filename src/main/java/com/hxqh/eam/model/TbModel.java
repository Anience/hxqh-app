package com.hxqh.eam.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the TB_MODEL database table.
 * 
 */
@Entity
@Table(name="TB_MODEL")
public class TbModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TB_MODEL_MODELID_GENERATOR", sequenceName="SEQ_MODEL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TB_MODEL_MODELID_GENERATOR")
	private long modelid;

	private BigDecimal ismdeol;

	private String modeldesc;

	private String modelname;

	private BigDecimal modelstatus;

	private BigDecimal parentid;

	private String remark;

	private BigDecimal sortnum;

	public TbModel() {
	}

	public long getModelid() {
		return this.modelid;
	}

	public void setModelid(long modelid) {
		this.modelid = modelid;
	}

	public BigDecimal getIsmdeol() {
		return this.ismdeol;
	}

	public void setIsmdeol(BigDecimal ismdeol) {
		this.ismdeol = ismdeol;
	}

	public String getModeldesc() {
		return this.modeldesc;
	}

	public void setModeldesc(String modeldesc) {
		this.modeldesc = modeldesc;
	}

	public String getModelname() {
		return this.modelname;
	}

	public void setModelname(String modelname) {
		this.modelname = modelname;
	}

	public BigDecimal getModelstatus() {
		return this.modelstatus;
	}

	public void setModelstatus(BigDecimal modelstatus) {
		this.modelstatus = modelstatus;
	}

	public BigDecimal getParentid() {
		return this.parentid;
	}

	public void setParentid(BigDecimal parentid) {
		this.parentid = parentid;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public BigDecimal getSortnum() {
		return this.sortnum;
	}

	public void setSortnum(BigDecimal sortnum) {
		this.sortnum = sortnum;
	}

}