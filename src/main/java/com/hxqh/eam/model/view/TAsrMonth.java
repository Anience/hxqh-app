package com.hxqh.eam.model.view;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * The persistent class for the T_ASR_MONTH database table.
 * 
 */
@Entity
@Table(name="T_ASR_MONTH")
public class TAsrMonth implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ASR_ID")
	private Long asrId;

	@Temporal(TemporalType.DATE)
	@Column(name="LAST_UPDATE")
	private Date lastUpdate;

	private String node;

	private String ts;

	@Column(name="W1_ANSWER")
	private Long w1Answer;

	@Column(name="W1_ASRERROR")
	private String w1Asrerror;

	@Column(name="W1_ASRSUCCESS")
	private String w1Asrsuccess;

	@Column(name="W1_ATTEMPT")
	private Long w1Attempt;

	@Column(name="W1_MM")
	private String w1Mm;

	@Column(name="W1_OGLOST")
	private Long w1Oglost;

	@Column(name="W1_TANGGAL")
	private String w1Tanggal;

	@Column(name="W1_YEARS")
	private String w1Years;

	@Column(name="W2_ANSWER")
	private Long w2Answer;

	@Column(name="W2_ASRERROR")
	private String w2Asrerror;

	@Column(name="W2_ASRSUCCESS")
	private String w2Asrsuccess;

	@Column(name="W2_ATTEMPT")
	private Long w2Attempt;

	@Column(name="W2_MM")
	private String w2Mm;

	@Column(name="W2_OGLOST")
	private Long w2Oglost;

	@Column(name="W2_TANGGAL")
	private String w2Tanggal;

	@Column(name="W2_YEARS")
	private String w2Years;

	public TAsrMonth() {
	}

	public Long getAsrId() {
		return this.asrId;
	}

	public void setAsrId(Long asrId) {
		this.asrId = asrId;
	}

	public Date getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public String getNode() {
		return this.node;
	}

	public void setNode(String node) {
		this.node = node;
	}

	public String getTs() {
		return this.ts;
	}

	public void setTs(String ts) {
		this.ts = ts;
	}

	public Long getW1Answer() {
		return this.w1Answer;
	}

	public void setW1Answer(Long w1Answer) {
		this.w1Answer = w1Answer;
	}

	public String getW1Asrerror() {
		return this.w1Asrerror;
	}

	public void setW1Asrerror(String w1Asrerror) {
		this.w1Asrerror = w1Asrerror;
	}

	public String getW1Asrsuccess() {
		return this.w1Asrsuccess;
	}

	public void setW1Asrsuccess(String w1Asrsuccess) {
		this.w1Asrsuccess = w1Asrsuccess;
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

	public String getW1Tanggal() {
		return this.w1Tanggal;
	}

	public void setW1Tanggal(String w1Tanggal) {
		this.w1Tanggal = w1Tanggal;
	}

	public String getW1Years() {
		return this.w1Years;
	}

	public void setW1Years(String w1Years) {
		this.w1Years = w1Years;
	}

	public Long getW2Answer() {
		return this.w2Answer;
	}

	public void setW2Answer(Long w2Answer) {
		this.w2Answer = w2Answer;
	}

	public String getW2Asrerror() {
		return this.w2Asrerror;
	}

	public void setW2Asrerror(String w2Asrerror) {
		this.w2Asrerror = w2Asrerror;
	}

	public String getW2Asrsuccess() {
		return this.w2Asrsuccess;
	}

	public void setW2Asrsuccess(String w2Asrsuccess) {
		this.w2Asrsuccess = w2Asrsuccess;
	}

	public Long getW2Attempt() {
		return this.w2Attempt;
	}

	public void setW2Attempt(Long w2Attempt) {
		this.w2Attempt = w2Attempt;
	}

	public String getW2Mm() {
		return this.w2Mm;
	}

	public void setW2Mm(String w2Mm) {
		this.w2Mm = w2Mm;
	}

	public Long getW2Oglost() {
		return this.w2Oglost;
	}

	public void setW2Oglost(Long w2Oglost) {
		this.w2Oglost = w2Oglost;
	}

	public String getW2Tanggal() {
		return this.w2Tanggal;
	}

	public void setW2Tanggal(String w2Tanggal) {
		this.w2Tanggal = w2Tanggal;
	}

	public String getW2Years() {
		return this.w2Years;
	}

	public void setW2Years(String w2Years) {
		this.w2Years = w2Years;
	}

}