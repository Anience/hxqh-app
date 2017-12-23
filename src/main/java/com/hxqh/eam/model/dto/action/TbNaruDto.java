package com.hxqh.eam.model.dto.action;

import com.hxqh.eam.model.TbNaru;

import java.util.List;
import java.util.Map;

/**
 * Created by Ocean lin on 2017/12/23.
 */
public class TbNaruDto {

    private Map<String, List<TbNaru>> listMap;

    public TbNaruDto() {
    }

    public TbNaruDto(Map<String, List<TbNaru>> listMap) {
        this.listMap = listMap;
    }

    public Map<String, List<TbNaru>> getListMap() {
        return listMap;
    }

    public void setListMap(Map<String, List<TbNaru>> listMap) {
        this.listMap = listMap;
    }
}
