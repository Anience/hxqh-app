package com.hxqh.eam.model.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2017/6/29.
 */
public class TrafficTdo {
    private List<String> nameList;

    private Map<String, List<BigDecimal>> topMap;

    Map<String, List<BigDecimal>> bottomMap;

    public TrafficTdo() {
    }

    public TrafficTdo(List<String> nameList, Map<String, List<BigDecimal>> topMap, Map<String, List<BigDecimal>> bottomMap) {
        this.nameList = nameList;
        this.topMap = topMap;
        this.bottomMap = bottomMap;
    }

    public List<String> getNameList() {
        return nameList;
    }

    public void setNameList(List<String> nameList) {
        this.nameList = nameList;
    }

    public Map<String, List<BigDecimal>> getTopMap() {
        return topMap;
    }

    public void setTopMap(Map<String, List<BigDecimal>> topMap) {
        this.topMap = topMap;
    }

    public Map<String, List<BigDecimal>> getBottomMap() {
        return bottomMap;
    }

    public void setBottomMap(Map<String, List<BigDecimal>> bottomMap) {
        this.bottomMap = bottomMap;
    }
}
