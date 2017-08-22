package com.hxqh.eam.model.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * Created by Ocean lin on 2017/8/3.
 */
@Entity
public class SrDto {

    @Id
    private String regional;

    private Long smsbackend;

    private Long emailopen;

    private Long smsopen;

    private Long  emailbackend;

    private Long reopen;

    public String getRegional() {
        return regional;
    }

    public void setRegional(String regional) {
        this.regional = regional;
    }

    public Long getSmsbackend() {
        return smsbackend;
    }

    public void setSmsbackend(Long smsbackend) {
        this.smsbackend = smsbackend;
    }

    public Long getEmailopen() {
        return emailopen;
    }

    public void setEmailopen(Long emailopen) {
        this.emailopen = emailopen;
    }

    public Long getSmsopen() {
        return smsopen;
    }

    public void setSmsopen(Long smsopen) {
        this.smsopen = smsopen;
    }

    public Long getEmailbackend() {
        return emailbackend;
    }

    public void setEmailbackend(Long emailbackend) {
        this.emailbackend = emailbackend;
    }

    public Long getReopen() {
        return reopen;
    }

    public void setReopen(Long reopen) {
        this.reopen = reopen;
    }
}
