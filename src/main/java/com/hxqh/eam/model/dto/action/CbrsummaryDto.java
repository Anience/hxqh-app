package com.hxqh.eam.model.dto.action;

import com.hxqh.eam.model.view.VTotalMonthAsr;

import java.util.List;

/**
 * Created by Ocean lin on 2017/12/22.
 */
public class CbrsummaryDto {

    private ArsDto arsDto;

    private List<VTotalMonthAsr> vTotalMonthAsrs;

    public CbrsummaryDto() {
    }

    public CbrsummaryDto(ArsDto arsDto, List<VTotalMonthAsr> vTotalMonthAsrs) {
        this.arsDto = arsDto;
        this.vTotalMonthAsrs = vTotalMonthAsrs;
    }

    public List<VTotalMonthAsr> getvTotalMonthAsrs() {
        return vTotalMonthAsrs;
    }

    public void setvTotalMonthAsrs(List<VTotalMonthAsr> vTotalMonthAsrs) {
        this.vTotalMonthAsrs = vTotalMonthAsrs;
    }

    public ArsDto getArsDto() {
        return arsDto;
    }

    public void setArsDto(ArsDto arsDto) {
        this.arsDto = arsDto;
    }
}
