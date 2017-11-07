package com.hxqh.eam.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the TB_MOBILE_CNOP_MSG database table.
 */
@Entity
@Table(name = "TB_MOBILE_CNOP_MSG")
public class MobileCnopMsg implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "KPI_TYPE")
    private String kpiType;

    @Column(name = "KPI_VALUE")
    private BigDecimal kpiValue;

    private String msg;

    @Id
    @Column(name = "MSG_ID")
    private BigDecimal msgId;

    @Column(name = "SOURCE_TYPE")
    private String sourceType;

    private String treg;

    private String ts;

    public MobileCnopMsg() {
    }

    public String getKpiType() {
        return this.kpiType;
    }

    public void setKpiType(String kpiType) {
        this.kpiType = kpiType;
    }

    public BigDecimal getKpiValue() {
        return this.kpiValue;
    }

    public void setKpiValue(BigDecimal kpiValue) {
        this.kpiValue = kpiValue;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public BigDecimal getMsgId() {
        return this.msgId;
    }

    public void setMsgId(BigDecimal msgId) {
        this.msgId = msgId;
    }

    public String getSourceType() {
        return this.sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public String getTreg() {
        return this.treg;
    }

    public void setTreg(String treg) {
        this.treg = treg;
    }

    public String getTs() {
        return this.ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

}