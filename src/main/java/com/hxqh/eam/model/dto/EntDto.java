package com.hxqh.eam.model.dto;

import java.util.List;
import java.util.Map;

/**
 * Created by Ocean lin on 2017/7/13.
 */
public class EntDto {

    private List<EnterprisePieDto> pieRightnowList;
    private List<EnterprisePieDto> pieProactiveList;

    private Map<String, List<Integer>> rightnowTicketM;
    private Map<String, List<Integer>> proactiveTicketM;

    private List<String> nameList;

    private Map<String, List<Integer>> enterprise6Map;
    private Map<String, List<Integer>> enterprise7Map;
    private List<String> nRegionProductList;


    public EntDto(List<EnterprisePieDto> pieRightnowList, List<EnterprisePieDto> pieProactiveList, Map<String, List<Integer>> rightnowTicketM, Map<String, List<Integer>> proactiveTicketM, List<String> nameList, Map<String, List<Integer>> enterprise6Map, Map<String, List<Integer>> enterprise7Map, List<String> nRegionProductList) {
        this.pieRightnowList = pieRightnowList;
        this.pieProactiveList = pieProactiveList;
        this.rightnowTicketM = rightnowTicketM;
        this.proactiveTicketM = proactiveTicketM;
        this.nameList = nameList;
        this.enterprise6Map = enterprise6Map;
        this.enterprise7Map = enterprise7Map;
        this.nRegionProductList = nRegionProductList;
    }

    public List<EnterprisePieDto> getPieRightnowList() {
        return pieRightnowList;
    }

    public void setPieRightnowList(List<EnterprisePieDto> pieRightnowList) {
        this.pieRightnowList = pieRightnowList;
    }

    public List<EnterprisePieDto> getPieProactiveList() {
        return pieProactiveList;
    }

    public void setPieProactiveList(List<EnterprisePieDto> pieProactiveList) {
        this.pieProactiveList = pieProactiveList;
    }

    public Map<String, List<Integer>> getRightnowTicketM() {
        return rightnowTicketM;
    }

    public void setRightnowTicketM(Map<String, List<Integer>> rightnowTicketM) {
        this.rightnowTicketM = rightnowTicketM;
    }

    public Map<String, List<Integer>> getProactiveTicketM() {
        return proactiveTicketM;
    }

    public void setProactiveTicketM(Map<String, List<Integer>> proactiveTicketM) {
        this.proactiveTicketM = proactiveTicketM;
    }

    public Map<String, List<Integer>> getEnterprise6Map() {
        return enterprise6Map;
    }

    public void setEnterprise6Map(Map<String, List<Integer>> enterprise6Map) {
        this.enterprise6Map = enterprise6Map;
    }

    public Map<String, List<Integer>> getEnterprise7Map() {
        return enterprise7Map;
    }

    public void setEnterprise7Map(Map<String, List<Integer>> enterprise7Map) {
        this.enterprise7Map = enterprise7Map;
    }

    public List<String> getnRegionProductList() {
        return nRegionProductList;
    }

    public void setnRegionProductList(List<String> nRegionProductList) {
        this.nRegionProductList = nRegionProductList;
    }

    public List<String> getNameList() {
        return nameList;
    }

    public void setNameList(List<String> nameList) {
        this.nameList = nameList;
    }
}
