package com.hxqh.eam.model.view;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the V_ASR_DAYS database table.
 * 
 */
@Entity
@Table(name="V_ASR_DAYS")
public class VAsrDay implements Serializable {
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.DATE)
	@Column(name="AGG_TS")
	private Date aggTs;

	private BigDecimal answer;

	private BigDecimal attempt;

	@Column(name="DATE_TIMES")
	private String dateTimes;

	private BigDecimal iansww;

	private BigDecimal iseizw;

	private String node;

	private BigDecimal oansww;

	@Id
	private BigDecimal oglost;

	private BigDecimal oseizw;

	private BigDecimal weekdays;

	public VAsrDay() {
	}

	public Date getAggTs() {
		return this.aggTs;
	}

	public void setAggTs(Date aggTs) {
		this.aggTs = aggTs;
	}

	public BigDecimal getAnswer() {
		return this.answer;
	}

	public void setAnswer(BigDecimal answer) {
		this.answer = answer;
	}

	public BigDecimal getAttempt() {
		return this.attempt;
	}

	public void setAttempt(BigDecimal attempt) {
		this.attempt = attempt;
	}

	public String getDateTimes() {
		return this.dateTimes;
	}

	public void setDateTimes(String dateTimes) {
		this.dateTimes = dateTimes;
	}

	public BigDecimal getIansww() {
		return this.iansww;
	}

	public void setIansww(BigDecimal iansww) {
		this.iansww = iansww;
	}

	public BigDecimal getIseizw() {
		return this.iseizw;
	}

	public void setIseizw(BigDecimal iseizw) {
		this.iseizw = iseizw;
	}

	public String getNode() {
		return this.node;
	}

	public void setNode(String node) {
		this.node = node;
	}

	public BigDecimal getOansww() {
		return this.oansww;
	}

	public void setOansww(BigDecimal oansww) {
		this.oansww = oansww;
	}

	public BigDecimal getOglost() {
		return this.oglost;
	}

	public void setOglost(BigDecimal oglost) {
		this.oglost = oglost;
	}

	public BigDecimal getOseizw() {
		return this.oseizw;
	}

	public void setOseizw(BigDecimal oseizw) {
		this.oseizw = oseizw;
	}

	public BigDecimal getWeekdays() {
		return this.weekdays;
	}

	public void setWeekdays(BigDecimal weekdays) {
		this.weekdays = weekdays;
	}

}