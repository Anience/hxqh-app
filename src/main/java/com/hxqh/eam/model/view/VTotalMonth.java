package com.hxqh.eam.model.view;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


/**
 * The persistent class for the V_TOTAL_MONTH database table.
 * 
 */
@Entity
@Table(name="V_TOTAL_MONTH")
public class VTotalMonth implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="W1_ANSWER")
	private Long w1Answer;

	@Column(name="W1_ATTEMPT")
	private Long w1Attempt;

	@Id
	@Column(name="W1_MM")
	private String w1Mm;

	@Column(name="W1_OGLOST")
	private Long w1Oglost;

	@Column(name="W2_ANSWER")
	private Long w2Answer;

	@Column(name="W2_ATTEMPT")
	private Long w2Attempt;

	@Column(name="W2_OGLOST")
	private Long w2Oglost;

	public VTotalMonth() {
	}

	public Long getW1Answer() {
		return this.w1Answer;
	}

	public void setW1Answer(Long w1Answer) {
		this.w1Answer = w1Answer;
	}

	public Long getW1Attempt() {
		return this.w1Attempt;
	}

	public void setW1Attempt(Long w1Attempt) {
		this.w1Attempt = w1Attempt;
	}

	public String getW1Mm() {
		return this.w1Mm;
	}

	public void setW1Mm(String w1Mm) {
		this.w1Mm = w1Mm;
	}

	public Long getW1Oglost() {
		return this.w1Oglost;
	}

	public void setW1Oglost(Long w1Oglost) {
		this.w1Oglost = w1Oglost;
	}

	public Long getW2Answer() {
		return this.w2Answer;
	}

	public void setW2Answer(Long w2Answer) {
		this.w2Answer = w2Answer;
	}

	public Long getW2Attempt() {
		return this.w2Attempt;
	}

	public void setW2Attempt(Long w2Attempt) {
		this.w2Attempt = w2Attempt;
	}

	public Long getW2Oglost() {
		return this.w2Oglost;
	}

	public void setW2Oglost(Long w2Oglost) {
		this.w2Oglost = w2Oglost;
	}

}