package com.hxqh.eam.model.dto;

import java.util.List;
import java.util.Map;

/**
 * Created by Ocean lin on 2017/7/19.
 */
public class ThroughtputDto {

    private Map<String, ThroughtputAgte> agteMap;

    private List<String> namelist;

    private List<String> lastTime;

    public ThroughtputDto() {
    }



    public ThroughtputDto(Map<String, ThroughtputAgte> agteMap, List<String> namelist, List<String> lastTime) {
        this.agteMap = agteMap;
        this.namelist = namelist;
        this.lastTime = lastTime;
    }

    public List<String> getNamelist() {
        return namelist;
    }

    public void setNamelist(List<String> namelist) {
        this.namelist = namelist;
    }

    public Map<String, ThroughtputAgte> getAgteMap() {
        return agteMap;
    }

    public void setAgteMap(Map<String, ThroughtputAgte> agteMap) {
        this.agteMap = agteMap;
    }

    public List<String> getLastTime() {
        return lastTime;
    }

    public void setLastTime(List<String> lastTime) {
        this.lastTime = lastTime;
    }
}


