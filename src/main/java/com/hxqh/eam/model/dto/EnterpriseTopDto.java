package com.hxqh.eam.model.dto;

import com.hxqh.eam.model.sqlquery.EnterpriseKTK;

import java.util.List;
import java.util.Map;

/**
 * Created by Ocean lin on 2017/7/11.
 */
public class EnterpriseTopDto {

    private List<String> rightnowNameList;
    private List<String> proactiveNameList;

    private Map<String, List<EnterpriseKTK>> rightnowTicketMap;
    private Map<String, List<EnterpriseKTK>> proactiveTicketMap;

    public EnterpriseTopDto() {
    }

    public EnterpriseTopDto(List<String> rightnowNameList, List<String> proactiveNameList, Map<String, List<EnterpriseKTK>> rightnowTicketMap, Map<String, List<EnterpriseKTK>> proactiveTicketMap) {
        this.rightnowNameList = rightnowNameList;
        this.proactiveNameList = proactiveNameList;
        this.rightnowTicketMap = rightnowTicketMap;
        this.proactiveTicketMap = proactiveTicketMap;
    }

    public List<String> getRightnowNameList() {
        return rightnowNameList;
    }

    public void setRightnowNameList(List<String> rightnowNameList) {
        this.rightnowNameList = rightnowNameList;
    }

    public List<String> getProactiveNameList() {
        return proactiveNameList;
    }

    public void setProactiveNameList(List<String> proactiveNameList) {
        this.proactiveNameList = proactiveNameList;
    }

    public Map<String, List<EnterpriseKTK>> getRightnowTicketMap() {
        return rightnowTicketMap;
    }

    public void setRightnowTicketMap(Map<String, List<EnterpriseKTK>> rightnowTicketMap) {
        this.rightnowTicketMap = rightnowTicketMap;
    }

    public Map<String, List<EnterpriseKTK>> getProactiveTicketMap() {
        return proactiveTicketMap;
    }

    public void setProactiveTicketMap(Map<String, List<EnterpriseKTK>> proactiveTicketMap) {
        this.proactiveTicketMap = proactiveTicketMap;
    }
}
