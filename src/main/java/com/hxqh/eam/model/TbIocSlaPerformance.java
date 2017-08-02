package com.hxqh.eam.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the TB_IOC_SLA_PERFORMANCE database table.
 * 
 */
@Entity
@Table(name="TB_IOC_SLA_PERFORMANCE")
public class TbIocSlaPerformance implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="CLOSE_YEARS")
	private BigDecimal closeYears;

	@Column(name="COLSE_MTTR_LEFT")
	private BigDecimal colseMttrLeft;

	@Column(name="CUST_TYPE")
	private String custType;

	@Column(name="OPEN_MTTR_LEFT")
	private BigDecimal openMttrLeft;

	@Column(name="PIE_LABEL")
	private String pieLabel;

	@Column(name="R_MTT")
	private BigDecimal rMtt;

	@Column(name="SEGMENT_TYPE")
	private String segmentType;

	@Id
	@Column(name="SLA_ID")
	private BigDecimal slaId;

	@Column(name="SLA_TYPE")
	private String slaType;

	@Column(name="T_STANDARD")
	private String tStandard;

	@Column(name="TICKET_NUMS")
	private BigDecimal ticketNums;

	@Column(name="TICKET_STATUS")
	private BigDecimal ticketStatus;

	private String ts;

	public TbIocSlaPerformance() {
	}

	public BigDecimal getCloseYears() {
		return this.closeYears;
	}

	public void setCloseYears(BigDecimal closeYears) {
		this.closeYears = closeYears;
	}

	public BigDecimal getColseMttrLeft() {
		return this.colseMttrLeft;
	}

	public void setColseMttrLeft(BigDecimal colseMttrLeft) {
		this.colseMttrLeft = colseMttrLeft;
	}

	public String getCustType() {
		return this.custType;
	}

	public void setCustType(String custType) {
		this.custType = custType;
	}

	public BigDecimal getOpenMttrLeft() {
		return this.openMttrLeft;
	}

	public void setOpenMttrLeft(BigDecimal openMttrLeft) {
		this.openMttrLeft = openMttrLeft;
	}

	public String getPieLabel() {
		return this.pieLabel;
	}

	public void setPieLabel(String pieLabel) {
		this.pieLabel = pieLabel;
	}

	public BigDecimal getRMtt() {
		return this.rMtt;
	}

	public void setRMtt(BigDecimal rMtt) {
		this.rMtt = rMtt;
	}

	public String getSegmentType() {
		return this.segmentType;
	}

	public void setSegmentType(String segmentType) {
		this.segmentType = segmentType;
	}

	public BigDecimal getSlaId() {
		return this.slaId;
	}

	public void setSlaId(BigDecimal slaId) {
		this.slaId = slaId;
	}

	public String getSlaType() {
		return this.slaType;
	}

	public void setSlaType(String slaType) {
		this.slaType = slaType;
	}

	public String getTStandard() {
		return this.tStandard;
	}

	public void setTStandard(String tStandard) {
		this.tStandard = tStandard;
	}

	public BigDecimal getTicketNums() {
		return this.ticketNums;
	}

	public void setTicketNums(BigDecimal ticketNums) {
		this.ticketNums = ticketNums;
	}

	public BigDecimal getTicketStatus() {
		return this.ticketStatus;
	}

	public void setTicketStatus(BigDecimal ticketStatus) {
		this.ticketStatus = ticketStatus;
	}

	public String getTs() {
		return this.ts;
	}

	public void setTs(String ts) {
		this.ts = ts;
	}

}