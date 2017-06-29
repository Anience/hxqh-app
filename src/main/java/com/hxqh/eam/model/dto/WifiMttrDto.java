package com.hxqh.eam.model.dto;

import com.hxqh.eam.model.view.VWifiMttr;
import com.hxqh.eam.model.view.VWifiMttrList;

import java.util.List;

/**
 * Created by lenovo on 2017/6/29.
 */
public class WifiMttrDto {

    private List<VWifiMttr> vWifiMttrList;
    private List<VWifiMttrList> mttrListList;

    public WifiMttrDto() {
    }

    public WifiMttrDto(List<VWifiMttr> vWifiMttrList, List<VWifiMttrList> mttrListList) {
        this.vWifiMttrList = vWifiMttrList;
        this.mttrListList = mttrListList;
    }

    public List<VWifiMttr> getvWifiMttrList() {
        return vWifiMttrList;
    }

    public void setvWifiMttrList(List<VWifiMttr> vWifiMttrList) {
        this.vWifiMttrList = vWifiMttrList;
    }

    public List<VWifiMttrList> getMttrListList() {
        return mttrListList;
    }

    public void setMttrListList(List<VWifiMttrList> mttrListList) {
        this.mttrListList = mttrListList;
    }
}
