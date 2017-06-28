package com.hxqh.eam.model.dto;

import com.hxqh.eam.model.view.VEntBusBottomOne;
import com.hxqh.eam.model.view.VEntBusBottomThree;
import com.hxqh.eam.model.view.VEntBusBottomTwo;
import com.hxqh.eam.model.view.VEntBusTopOne;
import com.hxqh.eam.model.view.VEntBusTopThree;
import com.hxqh.eam.model.view.VEntBusTopTwo;

import java.util.List;

/**
 * Created by Ocean Lin on 2017/6/27.
 */
public class BussinessDto {

    private List<VEntBusBottomOne> vEntBusBottomOne;
    private List<VEntBusBottomThree> vEntBusBottomThree;
    private List<VEntBusBottomTwo> vEntBusBottomTwo;

    private List<VEntBusTopOne> vEntBusTopOne;
    private List<VEntBusTopThree> vEntBusTopThree;
    private List<VEntBusTopTwo> vEntBusTopTwo;

    public BussinessDto(List<VEntBusBottomOne> vEntBusBottomOne, List<VEntBusBottomThree> vEntBusBottomThree, List<VEntBusBottomTwo> vEntBusBottomTwo, List<VEntBusTopOne> vEntBusTopOne, List<VEntBusTopThree> vEntBusTopThree, List<VEntBusTopTwo> vEntBusTopTwo) {
        this.vEntBusBottomOne = vEntBusBottomOne;
        this.vEntBusBottomThree = vEntBusBottomThree;
        this.vEntBusBottomTwo = vEntBusBottomTwo;
        this.vEntBusTopOne = vEntBusTopOne;
        this.vEntBusTopThree = vEntBusTopThree;
        this.vEntBusTopTwo = vEntBusTopTwo;
    }

    public List<VEntBusBottomOne> getvEntBusBottomOne() {
        return vEntBusBottomOne;
    }

    public void setvEntBusBottomOne(List<VEntBusBottomOne> vEntBusBottomOne) {
        this.vEntBusBottomOne = vEntBusBottomOne;
    }

    public List<VEntBusBottomThree> getvEntBusBottomThree() {
        return vEntBusBottomThree;
    }

    public void setvEntBusBottomThree(List<VEntBusBottomThree> vEntBusBottomThree) {
        this.vEntBusBottomThree = vEntBusBottomThree;
    }

    public List<VEntBusBottomTwo> getvEntBusBottomTwo() {
        return vEntBusBottomTwo;
    }

    public void setvEntBusBottomTwo(List<VEntBusBottomTwo> vEntBusBottomTwo) {
        this.vEntBusBottomTwo = vEntBusBottomTwo;
    }

    public List<VEntBusTopOne> getvEntBusTopOne() {
        return vEntBusTopOne;
    }

    public void setvEntBusTopOne(List<VEntBusTopOne> vEntBusTopOne) {
        this.vEntBusTopOne = vEntBusTopOne;
    }

    public List<VEntBusTopThree> getvEntBusTopThree() {
        return vEntBusTopThree;
    }

    public void setvEntBusTopThree(List<VEntBusTopThree> vEntBusTopThree) {
        this.vEntBusTopThree = vEntBusTopThree;
    }

    public List<VEntBusTopTwo> getvEntBusTopTwo() {
        return vEntBusTopTwo;
    }

    public void setvEntBusTopTwo(List<VEntBusTopTwo> vEntBusTopTwo) {
        this.vEntBusTopTwo = vEntBusTopTwo;
    }
}
