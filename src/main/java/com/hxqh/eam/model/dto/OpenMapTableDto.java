package com.hxqh.eam.model.dto;

import com.hxqh.eam.model.view.VMapOpenmaptable;
import com.hxqh.eam.model.view.VMapOpenmaptableRighttable;

import java.util.List;

/**
 * Created by Ocean lin on 2017/7/4.
 */
public class OpenMapTableDto {
    private List<VMapOpenmaptable> mapOpenmaptableList;

    private List<VMapOpenmaptableRighttable> mapOpenmaptableRighttableList;

    public OpenMapTableDto(List<VMapOpenmaptable> mapOpenmaptableList, List<VMapOpenmaptableRighttable> mapOpenmaptableRighttableList) {
        this.mapOpenmaptableList = mapOpenmaptableList;
        this.mapOpenmaptableRighttableList = mapOpenmaptableRighttableList;
    }

    public List<VMapOpenmaptable> getMapOpenmaptableList() {
        return mapOpenmaptableList;
    }

    public void setMapOpenmaptableList(List<VMapOpenmaptable> mapOpenmaptableList) {
        this.mapOpenmaptableList = mapOpenmaptableList;
    }

    public List<VMapOpenmaptableRighttable> getMapOpenmaptableRighttableList() {
        return mapOpenmaptableRighttableList;
    }

    public void setMapOpenmaptableRighttableList(List<VMapOpenmaptableRighttable> mapOpenmaptableRighttableList) {
        this.mapOpenmaptableRighttableList = mapOpenmaptableRighttableList;
    }
}
