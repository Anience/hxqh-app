package com.hxqh.eam.model.dto;

import com.hxqh.eam.model.view.VEnterpriseTicket;

import java.util.List;

/**
 * Created by Ocean lin on 2017/7/11.
 */
public class EnterpriseTopDto {
    private List<VEnterpriseTicket> rightnowList;
    private List<VEnterpriseTicket> proactiveList;

    public EnterpriseTopDto(List<VEnterpriseTicket> rightnowList, List<VEnterpriseTicket> proactiveList) {
        this.rightnowList = rightnowList;
        this.proactiveList = proactiveList;
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
}
