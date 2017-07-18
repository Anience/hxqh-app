package com.hxqh.eam.model.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by Ocean lin on 2017/7/13.
 */
@Entity
public class Enterprise67Dto {

    private String treg;

    private String dh;

    private Integer personsum;

    @Id
    private Integer regionrn;

    public Enterprise67Dto() {
    }


    public Integer getRegionrn() {
        return regionrn;
    }

    public void setRegionrn(Integer regionrn) {
        this.regionrn = regionrn;
    }

    public String getTreg() {
        return treg;
    }

    public void setTreg(String treg) {
        this.treg = treg;
    }

    public String getDh() {
        return dh;
    }

    public void setDh(String dh) {
        this.dh = dh;
    }

    public Integer getPersonsum() {
        return personsum;
    }

    public void setPersonsum(Integer personsum) {
        this.personsum = personsum;
    }
}
