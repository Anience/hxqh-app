package com.hxqh.eam.model.dto;

import com.hxqh.eam.model.TbIocProTicketResult;

import java.util.List;
import java.util.Map;

/**
 * Created by Ocean lin on 2017/7/20.
 */
public class RealtimeData {

    private List<String> name3List;
    private List<Integer> value3List;

    private Map<String, List<TbIocProTicketResult>> pillartMap;
    private Map<String, List<Integer>> pillartM;

    private List<String> name2List;

    public RealtimeData(List<String> name3List, List<Integer> value3List, Map<String, List<TbIocProTicketResult>> pillartMap, Map<String, List<Integer>> pillartM, List<String> name2List) {
        this.name3List = name3List;
        this.value3List = value3List;
        this.pillartMap = pillartMap;
        this.pillartM = pillartM;
        this.name2List = name2List;
    }

    public List<String> getName3List() {
        return name3List;
    }

    public void setName3List(List<String> name3List) {
        this.name3List = name3List;
    }

    public List<Integer> getValue3List() {
        return value3List;
    }

    public void setValue3List(List<Integer> value3List) {
        this.value3List = value3List;
    }

    public Map<String, List<TbIocProTicketResult>> getPillartMap() {
        return pillartMap;
    }

    public void setPillartMap(Map<String, List<TbIocProTicketResult>> pillartMap) {
        this.pillartMap = pillartMap;
    }

    public Map<String, List<Integer>> getPillartM() {
        return pillartM;
    }

    public void setPillartM(Map<String, List<Integer>> pillartM) {
        this.pillartM = pillartM;
    }

    public List<String> getName2List() {
        return name2List;
    }

    public void setName2List(List<String> name2List) {
        this.name2List = name2List;
    }
}
