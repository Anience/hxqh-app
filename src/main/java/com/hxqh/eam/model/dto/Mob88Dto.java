package com.hxqh.eam.model.dto;

import com.hxqh.eam.model.view.VMob88Mtti;
import com.hxqh.eam.model.view.VMob88Mttr;
import com.hxqh.eam.model.view.VMob88Performance;

import java.util.List;

/**
 * Created by Ocean lin on 2017/6/29.
 */
public class Mob88Dto {

    private List<VMob88Mtti> mob88MttiList;
    private List<VMob88Mttr> mob88MttrList;
    private List<VMob88Performance> performanceList;

    public Mob88Dto(List<VMob88Mtti> mob88MttiList, List<VMob88Mttr> mob88MttrList, List<VMob88Performance> performanceList) {
        this.mob88MttiList = mob88MttiList;
        this.mob88MttrList = mob88MttrList;
        this.performanceList = performanceList;
    }

    public List<VMob88Mtti> getMob88MttiList() {
        return mob88MttiList;
    }

    public void setMob88MttiList(List<VMob88Mtti> mob88MttiList) {
        this.mob88MttiList = mob88MttiList;
    }

    public List<VMob88Mttr> getMob88MttrList() {
        return mob88MttrList;
    }

    public void setMob88MttrList(List<VMob88Mttr> mob88MttrList) {
        this.mob88MttrList = mob88MttrList;
    }

    public List<VMob88Performance> getPerformanceList() {
        return performanceList;
    }

    public void setPerformanceList(List<VMob88Performance> performanceList) {
        this.performanceList = performanceList;
    }
}
