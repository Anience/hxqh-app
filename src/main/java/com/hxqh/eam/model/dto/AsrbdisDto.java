package com.hxqh.eam.model.dto;

import com.hxqh.eam.model.dto.action.ArsDto;

import java.util.Map;

/**
 * Created by Ocean lin on 2017/12/22.
 */
public class AsrbdisDto {
    private Map<String, ArsDto> group;

    public AsrbdisDto() {
    }

    public AsrbdisDto(Map<String, ArsDto> group) {
        this.group = group;
    }

    public Map<String, ArsDto> getGroup() {
        return group;
    }

    public void setGroup(Map<String, ArsDto> group) {
        this.group = group;
    }
}
