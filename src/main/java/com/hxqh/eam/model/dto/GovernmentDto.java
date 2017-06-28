package com.hxqh.eam.model.dto;

import com.hxqh.eam.model.view.*;

import java.util.List;

/**
 * Created by Ocean Lin on 2017/6/27.
 */
public class GovernmentDto {


    private List<VEntGovTopOne> entGovTopOneList;

    private List<VEntGovTopTwo> entGovTopTwoList;

    private List<VEntGovTopThree> entGovTopThreeList;

    private List<VEntGovBottomOne> entGovBottomOneList;

    private List<VEntGovBottomTwo> entGovBottomTwoList;

    private List<VEntGovBottomThree> entGovBottomThreeList;


    public GovernmentDto() {
    }

    public GovernmentDto(List<VEntGovTopOne> entGovTopOneList, List<VEntGovTopTwo> entGovTopTwoList, List<VEntGovTopThree> entGovTopThreeList, List<VEntGovBottomOne> entGovBottomOneList, List<VEntGovBottomTwo> entGovBottomTwoList, List<VEntGovBottomThree> entGovBottomThreeList) {
        this.entGovTopOneList = entGovTopOneList;
        this.entGovTopTwoList = entGovTopTwoList;
        this.entGovTopThreeList = entGovTopThreeList;
        this.entGovBottomOneList = entGovBottomOneList;
        this.entGovBottomTwoList = entGovBottomTwoList;
        this.entGovBottomThreeList = entGovBottomThreeList;
    }

    public List<VEntGovTopOne> getEntGovTopOneList() {
        return entGovTopOneList;
    }

    public void setEntGovTopOneList(List<VEntGovTopOne> entGovTopOneList) {
        this.entGovTopOneList = entGovTopOneList;
    }

    public List<VEntGovTopTwo> getEntGovTopTwoList() {
        return entGovTopTwoList;
    }

    public void setEntGovTopTwoList(List<VEntGovTopTwo> entGovTopTwoList) {
        this.entGovTopTwoList = entGovTopTwoList;
    }

    public List<VEntGovTopThree> getEntGovTopThreeList() {
        return entGovTopThreeList;
    }

    public void setEntGovTopThreeList(List<VEntGovTopThree> entGovTopThreeList) {
        this.entGovTopThreeList = entGovTopThreeList;
    }

    public List<VEntGovBottomOne> getEntGovBottomOneList() {
        return entGovBottomOneList;
    }

    public void setEntGovBottomOneList(List<VEntGovBottomOne> entGovBottomOneList) {
        this.entGovBottomOneList = entGovBottomOneList;
    }

    public List<VEntGovBottomTwo> getEntGovBottomTwoList() {
        return entGovBottomTwoList;
    }

    public void setEntGovBottomTwoList(List<VEntGovBottomTwo> entGovBottomTwoList) {
        this.entGovBottomTwoList = entGovBottomTwoList;
    }

    public List<VEntGovBottomThree> getEntGovBottomThreeList() {
        return entGovBottomThreeList;
    }

    public void setEntGovBottomThreeList(List<VEntGovBottomThree> entGovBottomThreeList) {
        this.entGovBottomThreeList = entGovBottomThreeList;
    }
}
