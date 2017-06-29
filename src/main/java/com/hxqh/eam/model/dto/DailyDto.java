package com.hxqh.eam.model.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2017/6/29.
 */
public class DailyDto {

    private Map<String, List<BigDecimal>> skuIdMap;

    private List<String> list;

    public DailyDto(Map<String, List<BigDecimal>> skuIdMap, List<String> list) {
        this.skuIdMap = skuIdMap;
        this.list = list;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Map<String, List<BigDecimal>> getSkuIdMap() {
        return skuIdMap;
    }

    public void setSkuIdMap(Map<String, List<BigDecimal>> skuIdMap) {
        this.skuIdMap = skuIdMap;
    }
}
