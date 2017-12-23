package com.hxqh.eam.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by Ocean lin on 2017/12/23.
 */
@Entity
@Table(name = "TB_NARU")
public class TbNaru implements Serializable {

    @Id
    @Column(name = "TB_NARU_ID")
    private Integer tbnaruid;

    private String chartnum;

    private String charttitle;

    private String items;

    private String value;


    public TbNaru() {
    }

    public Integer getTbnaruid() {
        return tbnaruid;
    }

    public void setTbnaruid(Integer tbnaruid) {
        this.tbnaruid = tbnaruid;
    }

    public String getChartnum() {
        return chartnum;
    }

    public void setChartnum(String chartnum) {
        this.chartnum = chartnum;
    }

    public String getCharttitle() {
        return charttitle;
    }

    public void setCharttitle(String charttitle) {
        this.charttitle = charttitle;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
