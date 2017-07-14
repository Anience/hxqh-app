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


    private List<Enterprise67Dto> ent6List;
    private List<Enterprise67Dto> ent7List;

    public EntDto(List<EnterprisePieDto> pieRightnowList, List<EnterprisePieDto> pieProactiveList, Map<String, List<Integer>> rightnowTicketM, Map<String, List<Integer>> proactiveTicketM, List<String> nameList, List<Enterprise67Dto> ent6List, List<Enterprise67Dto> ent7List) {
        this.pieRightnowList = pieRightnowList;
        this.pieProactiveList = pieProactiveList;
        this.rightnowTicketM = rightnowTicketM;
        this.proactiveTicketM = proactiveTicketM;
        this.nameList = nameList;
        this.ent6List = ent6List;
        this.ent7List = ent7List;
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

    public List<Enterprise67Dto> getEnt6List() {
        return ent6List;
    }

    public void setEnt6List(List<Enterprise67Dto> ent6List) {
        this.ent6List = ent6List;
    }

    public List<Enterprise67Dto> getEnt7List() {
        return ent7List;
    }

    public void setEnt7List(List<Enterprise67Dto> ent7List) {
        this.ent7List = ent7List;
    }

    public List<String> getNameList() {
        return nameList;
    }

    public void setNameList(List<String> nameList) {
        this.nameList = nameList;
    }
}
