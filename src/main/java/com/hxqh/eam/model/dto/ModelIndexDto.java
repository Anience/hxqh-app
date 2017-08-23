package com.hxqh.eam.model.dto;

import com.hxqh.eam.model.TbModel;

import java.util.Set;

/**
 * Created by Ocean lin on 2017/8/23.
 */
public class ModelIndexDto {
    private Set<TbModel> modelList;

    public ModelIndexDto(Set<TbModel> modelList) {
        this.modelList = modelList;
    }

    public Set<TbModel> getModelList() {
        return modelList;
    }

    public void setModelList(Set<TbModel> modelList) {
        this.modelList = modelList;
    }
}
