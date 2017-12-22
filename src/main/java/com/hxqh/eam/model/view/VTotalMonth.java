package com.hxqh.eam.model.view;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the V_TOTAL_MONTH database table.
 * 
 */
@Entity
@Table(name="V_TOTAL_MONTH")
public class VTotalMonth implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="W1_ANSWER")
	private BigDecimal w1Answer;

	@Column(name="W1_ATTEMPT")
	private BigDecimal w1Attempt;

	@Id
	@Column(name="W1_MM")
	private String w1Mm;

	@Column(name="W1_OGLOST")
	private BigDecimal w1Oglost;

	@Column(name="W2_ANSWER")
	private BigDecimal w2Answer;

	@Column(name="W2_ATTEMPT")
	private BigDecimal w2Attempt;

	@Column(name="W2_OGLOST")
	private BigDecimal w2Oglost;

	public VTotalMonth() {
	}

	public BigDecimal getW1Answer() {
		return this.w1Answer;
	}

	public void setW1Answer(BigDecimal w1Answer) {
		this.w1Answer = w1Answer;
	}

	public BigDecimal getW1Attempt() {
		return this.w1Attempt;
	}

	public void setW1Attempt(BigDecimal w1Attempt) {
		this.w1Attempt = w1Attempt;
	}

	public String getW1Mm() {
		return this.w1Mm;
	}

	public void setW1Mm(String w1Mm) {
		this.w1Mm = w1Mm;
	}

	public BigDecimal getW1Oglost() {
		return this.w1Oglost;
	}

	public void setW1Oglost(BigDecimal w1Oglost) {
		this.w1Oglost = w1Oglost;
	}

	public BigDecimal getW2Answer() {
		return this.w2Answer;
	}

	public void setW2Answer(BigDecimal w2Answer) {
		this.w2Answer = w2Answer;
	}

	public BigDecimal getW2Attempt() {
		return this.w2Attempt;
	}

	public void setW2Attempt(BigDecimal w2Attempt) {
		this.w2Attempt = w2Attempt;
	}

	public BigDecimal getW2Oglost() {
		return this.w2Oglost;
	}

	public void setW2Oglost(BigDecimal w2Oglost) {
		this.w2Oglost = w2Oglost;
	}

}