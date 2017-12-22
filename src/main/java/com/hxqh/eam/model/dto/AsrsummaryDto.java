package com.hxqh.eam.model.dto;

import com.hxqh.eam.model.view.TAsrWeek;

import java.util.List;
import java.util.Map;

/**
 * Created by Ocean lin on 2017/12/22.
 */
public class AsrsummaryDto {

    private Map<String, List<TAsrWeek>> group;

    public AsrsummaryDto() {
    }

    public AsrsummaryDto(Map<String, List<TAsrWeek>> group) {
        this.group = group;
    }

    public Map<String, List<TAsrWeek>> getGroup() {
        return group;
    }

    public void setGroup(Map<String, List<TAsrWeek>> group) {
        this.group = group;
    }
}
