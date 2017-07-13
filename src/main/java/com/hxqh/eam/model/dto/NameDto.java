package com.hxqh.eam.model.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Ocean lin on 2017/7/13.
 */
@Entity
public class NameDto {
    @Id
    private String cname;

    public NameDto() {
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }
}
