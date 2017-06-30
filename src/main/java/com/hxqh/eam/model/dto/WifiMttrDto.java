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
    private Map<String ,List<VWifiMttrList>> leftList;
    private Map<String ,List<VWifiMttrList>> rightList;

    public WifiMttrDto() {
    }

    public WifiMttrDto(List<VWifiMttr> vWifiMttrList, Map<String, List<VWifiMttrList>> leftList, Map<String, List<VWifiMttrList>> rightList) {
        this.vWifiMttrList = vWifiMttrList;
        this.leftList = leftList;
        this.rightList = rightList;
    }

    public List<VWifiMttr> getvWifiMttrList() {
        return vWifiMttrList;
    }

    public void setvWifiMttrList(List<VWifiMttr> vWifiMttrList) {
        this.vWifiMttrList = vWifiMttrList;
    }

    public Map<String, List<VWifiMttrList>> getLeftList() {
        return leftList;
    }

    public void setLeftList(Map<String, List<VWifiMttrList>> leftList) {
        this.leftList = leftList;
    }

    public Map<String, List<VWifiMttrList>> getRightList() {
        return rightList;
    }

    public void setRightList(Map<String, List<VWifiMttrList>> rightList) {
        this.rightList = rightList;
    }
}
