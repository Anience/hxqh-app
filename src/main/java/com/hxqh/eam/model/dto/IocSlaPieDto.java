package com.hxqh.eam.model.dto;

import com.hxqh.eam.model.TbIocSlaPerformance;

import java.util.List;
import java.util.Map;

/**
 * Created by Ocean lin on 2017/8/3.
 */
public class IocSlaPieDto {

    private TbIocSlaPerformance pieObj;

    private Map<String,List<TbIocSlaPerformance>> pieMap;

    public TbIocSlaPerformance getPieObj() {
        return pieObj;
    }

    public void setPieObj(TbIocSlaPerformance pieObj) {
        this.pieObj = pieObj;
    }

    public Map<String, List<TbIocSlaPerformance>> getPieMap() {
        return pieMap;
    }

    public void setPieMap(Map<String, List<TbIocSlaPerformance>> pieMap) {
        this.pieMap = pieMap;
    }
}
