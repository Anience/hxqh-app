package com.hxqh.eam.model.dto;

import com.hxqh.eam.model.TbIocMobileIpTransit;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Ocean lin on 2017/7/19.
 */
public class ThroughtputDto {

    private Map<String, List<BigDecimal>> inM;
    private Map<String, List<BigDecimal>> outM;

    private List<TbIocMobileIpTransit> opersList;
    private List<TbIocMobileIpTransit> wrongList;

    private List<String> namelist;

    public ThroughtputDto() {
    }

    public ThroughtputDto(Map<String, List<BigDecimal>> inM, Map<String, List<BigDecimal>> outM, List<TbIocMobileIpTransit> opersList, List<TbIocMobileIpTransit> wrongList, List<String> namelist) {
        this.inM = inM;
        this.outM = outM;
        this.opersList = opersList;
        this.wrongList = wrongList;
        this.namelist = namelist;
    }

    public Map<String, List<BigDecimal>> getInM() {
        return inM;
    }

    public void setInM(Map<String, List<BigDecimal>> inM) {
        this.inM = inM;
    }

    public Map<String, List<BigDecimal>> getOutM() {
        return outM;
    }

    public void setOutM(Map<String, List<BigDecimal>> outM) {
        this.outM = outM;
    }

    public List<TbIocMobileIpTransit> getOpersList() {
        return opersList;
    }

    public void setOpersList(List<TbIocMobileIpTransit> opersList) {
        this.opersList = opersList;
    }

    public List<TbIocMobileIpTransit> getWrongList() {
        return wrongList;
    }

    public void setWrongList(List<TbIocMobileIpTransit> wrongList) {
        this.wrongList = wrongList;
    }

    public List<String> getNamelist() {
        return namelist;
    }

    public void setNamelist(List<String> namelist) {
        this.namelist = namelist;
    }
}


