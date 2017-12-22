package com.hxqh.eam.model.view;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


/**
 * The persistent class for the V_NODEWEEKSTATISTICS database table.
 */
@Entity
@Table(name = "V_NODEWEEKSTATISTICS")
public class VNodeweekstatistic implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "W1_ANSWER")
    private Long w1Answer;

    @Column(name = "W1_ASR")
    private String w1Asr;

    @Column(name = "W1_ATTEMPT")
    private Long w1Attempt;

    @Column(name = "W1_OGLOST")
    private Long w1Oglost;

    @Column(name = "W1_TANGGAL")
    private String w1Tanggal;

    @Column(name = "W2_ANSWER")
    private Long w2Answer;

    @Column(name = "W2_ASR")
    private String w2Asr;

    @Column(name = "W2_ATTEMPT")
    private Long w2Attempt;

    @Column(name = "W2_OGLOST")
    private Long w2Oglost;

    @Id
    private String weekday;

    public VNodeweekstatistic() {
    }

    public Long getW1Answer() {
        return this.w1Answer;
    }

    public void setW1Answer(Long w1Answer) {
        this.w1Answer = w1Answer;
    }

    public String getW1Asr() {
        return this.w1Asr;
    }

    public void setW1Asr(String w1Asr) {
        this.w1Asr = w1Asr;
    }

    public Long getW1Attempt() {
        return this.w1Attempt;
    }

    public void setW1Attempt(Long w1Attempt) {
        this.w1Attempt = w1Attempt;
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

    public Long getW2Answer() {
        return this.w2Answer;
    }

    public void setW2Answer(Long w2Answer) {
        this.w2Answer = w2Answer;
    }

    public String getW2Asr() {
        return this.w2Asr;
    }

    public void setW2Asr(String w2Asr) {
        this.w2Asr = w2Asr;
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

    public String getWeekday() {
        return this.weekday;
    }

    public void setWeekday(String weekday) {
        this.weekday = weekday;
    }

}