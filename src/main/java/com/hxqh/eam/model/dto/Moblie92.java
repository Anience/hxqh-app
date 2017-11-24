package com.hxqh.eam.model.dto;

import java.util.Map;
import java.util.List;

/**
 * Created by Ocean lin on 2017/7/16.
 */
public class Moblie92 {

    private Map<String,Mob92Dto> dtoMap;

    private List<String> timeList;


    public Moblie92(Map<String, Mob92Dto> dtoMap, List<String> timeList) {
        this.dtoMap = dtoMap;
        this.timeList = timeList;
    }



    public Map<String, Mob92Dto> getDtoMap() {
        return dtoMap;
    }

    public void setDtoMap(Map<String, Mob92Dto> dtoMap) {
        this.dtoMap = dtoMap;
    }

    public List<String> getTimeList() {
        return timeList;
    }

    public void setTimeList(List<String> timeList) {
        this.timeList = timeList;
    }
}
