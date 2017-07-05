package com.hxqh.eam.model.dto;

import com.hxqh.eam.model.view.VEntProactive;
import com.hxqh.eam.model.view.VEntReactive;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Created by Ocean lin on 2017/7/5.
 */
public class EnterpriseDto {

    private List<VEntProactive> entProactiveList;

    private List<VEntReactive> entReactiveList;

    private Map<String, List<BigDecimal>> entReactivetktM;

    private Map<String, List<BigDecimal>> entProactivetktM;


    public EnterpriseDto(List<VEntProactive> entProactiveList, List<VEntReactive> entReactiveList, Map<String, List<BigDecimal>> entReactivetktM, Map<String, List<BigDecimal>> entProactivetktM) {
        this.entProactiveList = entProactiveList;
        this.entReactiveList = entReactiveList;
        this.entReactivetktM = entReactivetktM;
        this.entProactivetktM = entProactivetktM;
    }

    public List<VEntProactive> getEntProactiveList() {
        return entProactiveList;
    }

    public void setEntProactiveList(List<VEntProactive> entProactiveList) {
        this.entProactiveList = entProactiveList;
    }

    public List<VEntReactive> getEntReactiveList() {
        return entReactiveList;
    }

    public void setEntReactiveList(List<VEntReactive> entReactiveList) {
        this.entReactiveList = entReactiveList;
    }

    public Map<String, List<BigDecimal>> getEntReactivetktM() {
        return entReactivetktM;
    }

    public void setEntReactivetktM(Map<String, List<BigDecimal>> entReactivetktM) {
        this.entReactivetktM = entReactivetktM;
    }

    public Map<String, List<BigDecimal>> getEntProactivetktM() {
        return entProactivetktM;
    }

    public void setEntProactivetktM(Map<String, List<BigDecimal>> entProactivetktM) {
        this.entProactivetktM = entProactivetktM;
    }
}
