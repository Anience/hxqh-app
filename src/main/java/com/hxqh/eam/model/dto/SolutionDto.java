package com.hxqh.eam.model.dto;

import com.hxqh.eam.model.view.TbIocConsSrMoning;

import java.util.List;
import java.util.Map;

/**
 * Created by Ocean lin on 2017/7/20.
 */
public class SolutionDto {

    private Map<String, List<TbIocConsSrMoning>> listMap;
    private  List<SrMoningDto> moningDtoList;
    private List<SrDto> srDtoList;

    public SolutionDto(Map<String, List<TbIocConsSrMoning>> listMap, List<SrMoningDto> moningDtoList, List<SrDto> srDtoList) {
        this.listMap = listMap;
        this.moningDtoList = moningDtoList;
        this.srDtoList = srDtoList;
    }

    public List<SrDto> getSrDtoList() {
        return srDtoList;
    }

    public void setSrDtoList(List<SrDto> srDtoList) {
        this.srDtoList = srDtoList;
    }

    public Map<String, List<TbIocConsSrMoning>> getListMap() {
        return listMap;
    }

    public void setListMap(Map<String, List<TbIocConsSrMoning>> listMap) {
        this.listMap = listMap;
    }

    public List<SrMoningDto> getMoningDtoList() {
        return moningDtoList;
    }

    public void setMoningDtoList(List<SrMoningDto> moningDtoList) {
        this.moningDtoList = moningDtoList;
    }
}
