package com.hxqh.eam.model.dto;

import com.hxqh.eam.model.view.*;

import java.util.List;

/**
 * Created by Ocean Lin on 2017/6/27.
 */
public class EnterpriseDto {
    private List<VEntEntBottomOne> entEntBottomOneList;

    private List<VEntEntBottomThree> entEntBottomThreeList;

    private List<VEntEntBottomTwo> entEntBottomTwoList;

    private List<VEntEntTopOne> entEntTopOneList;

    private List<VEntEntTopThree> entEntTopThreeList;

    private List<VEntEntTopTwo> entEntTopTwoList;


    public EnterpriseDto() {
    }

    public EnterpriseDto(List<VEntEntBottomOne> entEntBottomOneList, List<VEntEntBottomThree> entEntBottomThreeList, List<VEntEntBottomTwo> entEntBottomTwoList, List<VEntEntTopOne> entEntTopOneList, List<VEntEntTopThree> entEntTopThreeList, List<VEntEntTopTwo> entEntTopTwoList) {
        this.entEntBottomOneList = entEntBottomOneList;
        this.entEntBottomThreeList = entEntBottomThreeList;
        this.entEntBottomTwoList = entEntBottomTwoList;
        this.entEntTopOneList = entEntTopOneList;
        this.entEntTopThreeList = entEntTopThreeList;
        this.entEntTopTwoList = entEntTopTwoList;
    }

    public List<VEntEntBottomOne> getEntEntBottomOneList() {
        return entEntBottomOneList;
    }

    public void setEntEntBottomOneList(List<VEntEntBottomOne> entEntBottomOneList) {
        this.entEntBottomOneList = entEntBottomOneList;
    }

    public List<VEntEntBottomThree> getEntEntBottomThreeList() {
        return entEntBottomThreeList;
    }

    public void setEntEntBottomThreeList(List<VEntEntBottomThree> entEntBottomThreeList) {
        this.entEntBottomThreeList = entEntBottomThreeList;
    }

    public List<VEntEntBottomTwo> getEntEntBottomTwoList() {
        return entEntBottomTwoList;
    }

    public void setEntEntBottomTwoList(List<VEntEntBottomTwo> entEntBottomTwoList) {
        this.entEntBottomTwoList = entEntBottomTwoList;
    }

    public List<VEntEntTopOne> getEntEntTopOneList() {
        return entEntTopOneList;
    }

    public void setEntEntTopOneList(List<VEntEntTopOne> entEntTopOneList) {
        this.entEntTopOneList = entEntTopOneList;
    }

    public List<VEntEntTopThree> getEntEntTopThreeList() {
        return entEntTopThreeList;
    }

    public void setEntEntTopThreeList(List<VEntEntTopThree> entEntTopThreeList) {
        this.entEntTopThreeList = entEntTopThreeList;
    }

    public List<VEntEntTopTwo> getEntEntTopTwoList() {
        return entEntTopTwoList;
    }

    public void setEntEntTopTwoList(List<VEntEntTopTwo> entEntTopTwoList) {
        this.entEntTopTwoList = entEntTopTwoList;
    }
}
