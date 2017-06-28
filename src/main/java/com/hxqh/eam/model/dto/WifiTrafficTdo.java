package com.hxqh.eam.model.dto;


import java.util.List;

/**
 * Created by Ocean Lin on 2017/6/27.
 */
public class WifiTrafficTdo {

    private List<WifiTrafficTopTdo> strTop;
    private List<String> nameList;

    public List<WifiTrafficTopTdo> getStrTop() {
        return strTop;
    }

    public void setStrTop(List<WifiTrafficTopTdo> strTop) {
        this.strTop = strTop;
    }

    public List<String> getNameList() {
        return nameList;
    }

    public void setNameList(List<String> nameList) {
        this.nameList = nameList;
    }
}
