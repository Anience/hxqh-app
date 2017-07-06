package com.hxqh.eam.model.dto;

import com.hxqh.eam.model.view.VGovProactive;
import com.hxqh.eam.model.view.VGovReactive;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Created by Ocean lin on 2017/7/5.
 */
public class GovernmentDto {
    private List<VGovProactive> govProactiveList;

    private List<VGovReactive> govReactiveList;

    private Map<String, List<BigDecimal>> govProactivetktM;

    private Map<String, List<BigDecimal>> govReactivetktM;

    public GovernmentDto(List<VGovProactive> govProactiveList, List<VGovReactive> govReactiveList, Map<String, List<BigDecimal>> govProactivetktM, Map<String, List<BigDecimal>> govReactivetktM) {
        this.govProactiveList = govProactiveList;
        this.govReactiveList = govReactiveList;
        this.govProactivetktM = govProactivetktM;
        this.govReactivetktM = govReactivetktM;
    }

    public List<VGovProactive> getGovProactiveList() {
        return govProactiveList;
    }

    public void setGovProactiveList(List<VGovProactive> govProactiveList) {
        this.govProactiveList = govProactiveList;
    }

    public List<VGovReactive> getGovReactiveList() {
        return govReactiveList;
    }

    public void setGovReactiveList(List<VGovReactive> govReactiveList) {
        this.govReactiveList = govReactiveList;
    }

    public Map<String, List<BigDecimal>> getGovProactivetktM() {
        return govProactivetktM;
    }

    public void setGovProactivetktM(Map<String, List<BigDecimal>> govProactivetktM) {
        this.govProactivetktM = govProactivetktM;
    }

    public Map<String, List<BigDecimal>> getGovReactivetktM() {
        return govReactivetktM;
    }

    public void setGovReactivetktM(Map<String, List<BigDecimal>> govReactivetktM) {
        this.govReactivetktM = govReactivetktM;
    }
}
