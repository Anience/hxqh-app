package com.hxqh.eam.model.dto;

import java.util.List;

/**
 * Created by Ocean Lin on 2017/6/28.
 */
public class WifiDailyDto {


    private List<String> nameList;
    private List<WifiTrafficTopTdo> cList;

    public WifiDailyDto(List<String> nameList, List<WifiTrafficTopTdo> cList) {
        this.nameList = nameList;
        this.cList = cList;
    }

    public List<String> getNameList() {
        return nameList;
    }

    public void setNameList(List<String> nameList) {
        this.nameList = nameList;
    }

    public List<WifiTrafficTopTdo> getcList() {
        return cList;
    }

    public void setcList(List<WifiTrafficTopTdo> cList) {
        this.cList = cList;
    }

}
