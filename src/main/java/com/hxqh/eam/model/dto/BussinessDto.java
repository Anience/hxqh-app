package com.hxqh.eam.model.dto;


import com.hxqh.eam.model.view.VBusProactive;
import com.hxqh.eam.model.view.VBusReactive;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Created by Ocean lin on 2017/7/5.
 */
public class BussinessDto {

    private List<VBusProactive> busProactiveList;

    private List<VBusReactive> busReactiveList;

    private Map<String, List<BigDecimal>> busProactivetktM;

    private Map<String, List<BigDecimal>> busReactivetktM;

    public BussinessDto(List<VBusProactive> busProactiveList, List<VBusReactive> busReactiveList, Map<String, List<BigDecimal>> busProactivetktM, Map<String, List<BigDecimal>> busReactivetktM) {
        this.busProactiveList = busProactiveList;
        this.busReactiveList = busReactiveList;
        this.busProactivetktM = busProactivetktM;
        this.busReactivetktM = busReactivetktM;
    }

    public List<VBusProactive> getBusProactiveList() {
        return busProactiveList;
    }

    public void setBusProactiveList(List<VBusProactive> busProactiveList) {
        this.busProactiveList = busProactiveList;
    }

    public List<VBusReactive> getBusReactiveList() {
        return busReactiveList;
    }

    public void setBusReactiveList(List<VBusReactive> busReactiveList) {
        this.busReactiveList = busReactiveList;
    }

    public Map<String, List<BigDecimal>> getBusProactivetktM() {
        return busProactivetktM;
    }

    public void setBusProactivetktM(Map<String, List<BigDecimal>> busProactivetktM) {
        this.busProactivetktM = busProactivetktM;
    }

    public Map<String, List<BigDecimal>> getBusReactivetktM() {
        return busReactivetktM;
    }

    public void setBusReactivetktM(Map<String, List<BigDecimal>> busReactivetktM) {
        this.busReactivetktM = busReactivetktM;
    }
}
