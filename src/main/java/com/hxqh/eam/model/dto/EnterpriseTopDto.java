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

    private EnterpriseThreeColor threeColor;

    private String name;

    private List<EnterpriseIconDto> iconList;

    private List<EnterpriseEventDto> eventList;

    private List<Enterprise67Dto> dto6List;

    private List<Enterprise67Dto> dto7List;


    public EnterpriseTopDto() {
    }

    public EnterpriseTopDto(List<VEnterpriseTicket> rightnowList, List<VEnterpriseTicket> proactiveList, List<String> rightnowNameList, List<String> proactiveNameList, Map<String, List<Integer>> rightnowTicketM, Map<String, List<Integer>> proactiveTicketM, EnterpriseThreeColor threeColor, String name, List<EnterpriseIconDto> iconList, List<EnterpriseEventDto> eventList, List<Enterprise67Dto> dto6List, List<Enterprise67Dto> dto7List) {
        this.rightnowList = rightnowList;
        this.proactiveList = proactiveList;
        this.rightnowNameList = rightnowNameList;
        this.proactiveNameList = proactiveNameList;
        this.rightnowTicketM = rightnowTicketM;
        this.proactiveTicketM = proactiveTicketM;
        this.threeColor = threeColor;
        this.name = name;
        this.iconList = iconList;
        this.eventList = eventList;
        this.dto6List = dto6List;
        this.dto7List = dto7List;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public EnterpriseThreeColor getThreeColor() {
        return threeColor;
    }

    public void setThreeColor(EnterpriseThreeColor threeColor) {
        this.threeColor = threeColor;
    }

    public List<EnterpriseIconDto> getIconList() {
        return iconList;
    }

    public void setIconList(List<EnterpriseIconDto> iconList) {
        this.iconList = iconList;
    }

    public List<EnterpriseEventDto> getEventList() {
        return eventList;
    }

    public void setEventList(List<EnterpriseEventDto> eventList) {
        this.eventList = eventList;
    }

    public List<Enterprise67Dto> getDto6List() {
        return dto6List;
    }

    public void setDto6List(List<Enterprise67Dto> dto6List) {
        this.dto6List = dto6List;
    }

    public List<Enterprise67Dto> getDto7List() {
        return dto7List;
    }

    public void setDto7List(List<Enterprise67Dto> dto7List) {
        this.dto7List = dto7List;
    }
}
