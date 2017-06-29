package com.hxqh.eam.model.dto;

import com.hxqh.eam.model.view.VWifiMttr;
import com.hxqh.eam.model.view.VWifiMttrList;

import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2017/6/29.
 */
public class WifiMttrDto {

    private List<VWifiMttr> vWifiMttrList;
    private Map<String ,List<VWifiMttrList>> mttrListList;

    public WifiMttrDto() {
    }

    public WifiMttrDto(List<VWifiMttr> vWifiMttrList, Map<String, List<VWifiMttrList>> mttrListList) {
        this.vWifiMttrList = vWifiMttrList;
        this.mttrListList = mttrListList;
    }

    public List<VWifiMttr> getvWifiMttrList() {
        return vWifiMttrList;
    }

    public void setvWifiMttrList(List<VWifiMttr> vWifiMttrList) {
        this.vWifiMttrList = vWifiMttrList;
    }

    public Map<String, List<VWifiMttrList>> getMttrListList() {
        return mttrListList;
    }

    public void setMttrListList(Map<String, List<VWifiMttrList>> mttrListList) {
        this.mttrListList = mttrListList;
    }
}
