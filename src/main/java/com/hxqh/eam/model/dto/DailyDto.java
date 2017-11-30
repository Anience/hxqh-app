package com.hxqh.eam.model.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2017/6/29.
 */
public class DailyDto {

    private Map<String, List<BigDecimal>> skuIdMap;

    private String[] dailyticket;

    private String nowtime;

    private List<String> lastTime;




    public DailyDto(Map<String, List<BigDecimal>> skuIdMap, String[] dailyticket, List<String> lastTime) {
        this.skuIdMap = skuIdMap;
        this.dailyticket = dailyticket;
        this.lastTime = lastTime;
    }

    public Map<String, List<BigDecimal>> getSkuIdMap() {
        return skuIdMap;
    }

    public void setSkuIdMap(Map<String, List<BigDecimal>> skuIdMap) {
        this.skuIdMap = skuIdMap;
    }

    public String[] getDailyticket() {
        return dailyticket;
    }

    public void setDailyticket(String[] dailyticket) {
        this.dailyticket = dailyticket;
    }

    public String getNowtime() {
        return nowtime;
    }

    public void setNowtime(String nowtime) {
        this.nowtime = nowtime;
    }

    public List<String> getLastTime() {
        return lastTime;
    }

    public void setLastTime(List<String> lastTime) {
        this.lastTime = lastTime;
    }
}
