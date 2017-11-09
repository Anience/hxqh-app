package com.hxqh.eam.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


/**
 * The persistent class for the TB_IOC_MOBILE_BACKHAUL_TTC database table.
 */
@Entity
@Table(name = "TB_IOC_MOBILE_BACKHAUL_TTC")
public class IocMobileBackhaulTtc implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "TTC_ID")
    private Long ttcId;

    private String allpath;

    private Integer catagory;

    @Column(name = "COLOR_TYPE")
    private Integer colorType;

    private Integer deptdepth;

    private String msg;

    @Column(name = "PARENT_ID")
    private Integer parentId;

    private String title;

    private String ts;

    public IocMobileBackhaulTtc() {
    }

    public Long getTtcId() {
        return ttcId;
    }

    public void setTtcId(Long ttcId) {
        this.ttcId = ttcId;
    }

    public String getAllpath() {
        return allpath;
    }

    public void setAllpath(String allpath) {
        this.allpath = allpath;
    }

    public Integer getCatagory() {
        return catagory;
    }

    public void setCatagory(Integer catagory) {
        this.catagory = catagory;
    }

    public Integer getColorType() {
        return colorType;
    }

    public void setColorType(Integer colorType) {
        this.colorType = colorType;
    }

    public Integer getDeptdepth() {
        return deptdepth;
    }

    public void setDeptdepth(Integer deptdepth) {
        this.deptdepth = deptdepth;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }
}