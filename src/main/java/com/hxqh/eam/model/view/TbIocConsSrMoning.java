package com.hxqh.eam.model.view;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the TB_IOC_CONS_SR_MONING database table.
 * 
 */
@Entity
@Table(name="V_IOC_CONS_SR_MONING")
public class TbIocConsSrMoning implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="\"A\"")
	private BigDecimal a;

	private BigDecimal b;

	private BigDecimal c;

	private BigDecimal d;

	private BigDecimal e;

	@Column(name="EMAIL_BACKEND")
	private String emailBackend;

	@Column(name="EMAIL_OPEN")
	private String emailOpen;

	private BigDecimal f;

	private String regional;

	private BigDecimal reopen;

	@Column(name="SMS_BACKEND")
	private String smsBackend;

	@Column(name="SMS_OPEN")
	private String smsOpen;

	@Id
	@Column(name="SR_ID")
	private BigDecimal srId;

	@Column(name="TITLE_TYPE")
	private String titleType;

	private String ts;

	private BigDecimal ttl;

	public TbIocConsSrMoning() {
	}

	public BigDecimal getA() {
		return this.a;
	}

	public void setA(BigDecimal a) {
		this.a = a;
	}

	public BigDecimal getB() {
		return this.b;
	}

	public void setB(BigDecimal b) {
		this.b = b;
	}

	public BigDecimal getC() {
		return this.c;
	}

	public void setC(BigDecimal c) {
		this.c = c;
	}

	public BigDecimal getD() {
		return this.d;
	}

	public void setD(BigDecimal d) {
		this.d = d;
	}

	public BigDecimal getE() {
		return this.e;
	}

	public void setE(BigDecimal e) {
		this.e = e;
	}

	public String getEmailBackend() {
		return this.emailBackend;
	}

	public void setEmailBackend(String emailBackend) {
		this.emailBackend = emailBackend;
	}

	public String getEmailOpen() {
		return this.emailOpen;
	}

	public void setEmailOpen(String emailOpen) {
		this.emailOpen = emailOpen;
	}

	public BigDecimal getF() {
		return this.f;
	}

	public void setF(BigDecimal f) {
		this.f = f;
	}

	public String getRegional() {
		return this.regional;
	}

	public void setRegional(String regional) {
		this.regional = regional;
	}

	public BigDecimal getReopen() {
		return this.reopen;
	}

	public void setReopen(BigDecimal reopen) {
		this.reopen = reopen;
	}

	public String getSmsBackend() {
		return this.smsBackend;
	}

	public void setSmsBackend(String smsBackend) {
		this.smsBackend = smsBackend;
	}

	public String getSmsOpen() {
		return this.smsOpen;
	}

	public void setSmsOpen(String smsOpen) {
		this.smsOpen = smsOpen;
	}

	public BigDecimal getSrId() {
		return this.srId;
	}

	public void setSrId(BigDecimal srId) {
		this.srId = srId;
	}

	public String getTitleType() {
		return this.titleType;
	}

	public void setTitleType(String titleType) {
		this.titleType = titleType;
	}

	public String getTs() {
		return this.ts;
	}

	public void setTs(String ts) {
		this.ts = ts;
	}

	public BigDecimal getTtl() {
		return this.ttl;
	}

	public void setTtl(BigDecimal ttl) {
		this.ttl = ttl;
	}

}