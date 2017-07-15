package com.hxqh.eam.model.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by Ocean lin on 2017/7/13.
 */
@Entity
public class Enterprise67Dto {

    //TODO  modify
    private String treg;

    private Date timedata;

    private Integer personsum;

    @Id
    private Integer rn ;

    public Enterprise67Dto() {
    }

    public Enterprise67Dto(String treg, Date timedata, Integer personsum, Integer rn) {
        this.treg = treg;
        this.timedata = timedata;
        this.personsum = personsum;
        this.rn = rn;
    }

    public Integer getRn() {
        return rn;
    }

    public void setRn(Integer rn) {
        this.rn = rn;
    }

    public String getTreg() {
        return treg;
    }

    public void setTreg(String treg) {
        this.treg = treg;
    }

    public Date getTimedata() {
        return timedata;
    }

    public void setTimedata(Date timedata) {
        this.timedata = timedata;
    }

    public Integer getPersonsum() {
        return personsum;
    }

    public void setPersonsum(Integer personsum) {
        this.personsum = personsum;
    }
}
