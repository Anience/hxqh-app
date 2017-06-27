package com.hxqh.eam.model.dto;

import com.hxqh.eam.model.view.VWifiTrafficBottom;
import com.hxqh.eam.model.view.VWifiTrafficTop;

import java.security.PrivateKey;
import java.util.List;

/**
 * Created by Ocean Lin on 2017/6/27.
 */
public class WifiTrafficTdo {
    private List<VWifiTrafficBottom> trafficBottomList;

    private List<VWifiTrafficTop> trafficTopList;

    public WifiTrafficTdo() {
    }

    public WifiTrafficTdo(List<VWifiTrafficBottom> trafficBottomList, List<VWifiTrafficTop> trafficTopList) {
        this.trafficBottomList = trafficBottomList;
        this.trafficTopList = trafficTopList;
    }

    public List<VWifiTrafficBottom> getTrafficBottomList() {
        return trafficBottomList;
    }

    public void setTrafficBottomList(List<VWifiTrafficBottom> trafficBottomList) {
        this.trafficBottomList = trafficBottomList;
    }

    public List<VWifiTrafficTop> getTrafficTopList() {
        return trafficTopList;
    }

    public void setTrafficTopList(List<VWifiTrafficTop> trafficTopList) {
        this.trafficTopList = trafficTopList;
    }
}
