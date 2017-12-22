package com.hxqh.eam.model.dto.action;

import java.util.Map;

/**
 * Created by Ocean lin on 2017/12/22.
 */
public class CbrbdisDto {

    private Map<String, ArsDto> group;

    public CbrbdisDto() {
    }

    public CbrbdisDto(Map<String, ArsDto> group) {
        this.group = group;
    }

    public Map<String, ArsDto> getGroup() {
        return group;
    }

    public void setGroup(Map<String, ArsDto> group) {
        this.group = group;
    }
}
