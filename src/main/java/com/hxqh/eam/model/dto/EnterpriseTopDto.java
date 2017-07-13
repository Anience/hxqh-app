package com.hxqh.eam.model.dto;

import com.hxqh.eam.model.view.VEnterpriseTicket;

import java.util.List;
import java.util.Map;

/**
 * Created by Ocean lin on 2017/7/11.
 */
public class EnterpriseTopDto {

    private List<VEnterpriseTicket> rightnowList;
    private List<VEnterpriseTicket> proactiveList;

    private List<String> rightnowNameList;
    private List<String> proactiveNameList;

    private Map<String, List<Integer>> rightnowTicketM;
    private Map<String, List<Integer>> proactiveTicketM;


    public EnterpriseTopDto() {
    }

    public EnterpriseTopDto(List<VEnterpriseTicket> rightnowList, List<VEnterpriseTicket> proactiveList, List<String> rightnowNameList, List<String> proactiveNameList, Map<String, List<Integer>> rightnowTicketM, Map<String, List<Integer>> proactiveTicketM) {
        this.rightnowList = rightnowList;
        this.proactiveList = proactiveList;
        this.rightnowNameList = rightnowNameList;
        this.proactiveNameList = proactiveNameList;
        this.rightnowTicketM = rightnowTicketM;
        this.proactiveTicketM = proactiveTicketM;
    }

    public List<VEnterpriseTicket> getRightnowList() {
        return rightnowList;
    }

    public void setRightnowList(List<VEnterpriseTicket> rightnowList) {
        this.rightnowList = rightnowList;
    }

    public List<VEnterpriseTicket> getProactiveList() {
        return proactiveList;
    }

    public void setProactiveList(List<VEnterpriseTicket> proactiveList) {
        this.proactiveList = proactiveList;
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
}
