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

    private String smsbackend;

    private String emailopen;

    private String smsopen;

    private String  emailbackend;

    private BigDecimal reopen;

    public String getRegional() {
        return regional;
    }

    public void setRegional(String regional) {
        this.regional = regional;
    }

    public String getSmsbackend() {
        return smsbackend;
    }

    public void setSmsbackend(String smsbackend) {
        this.smsbackend = smsbackend;
    }

    public String getEmailopen() {
        return emailopen;
    }

    public void setEmailopen(String emailopen) {
        this.emailopen = emailopen;
    }

    public String getSmsopen() {
        return smsopen;
    }

    public void setSmsopen(String smsopen) {
        this.smsopen = smsopen;
    }

    public String getEmailbackend() {
        return emailbackend;
    }

    public void setEmailbackend(String emailbackend) {
        this.emailbackend = emailbackend;
    }

    public BigDecimal getReopen() {
        return reopen;
    }

    public void setReopen(BigDecimal reopen) {
        this.reopen = reopen;
    }
}
