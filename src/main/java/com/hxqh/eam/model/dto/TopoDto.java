package com.hxqh.eam.model.dto;

import com.hxqh.eam.model.IocMobileBackhaulTtc;

import java.util.List;

/**
 * Created by Ocean lin on 2017/11/9.
 */
public class TopoDto {
    private List<Node> nodeList;
    private List<Line> lineList;
    private List<IocMobileBackhaulTtc> colorList;

    public TopoDto() {
    }

    public TopoDto(List<Node> nodeList, List<Line> lineList, List<IocMobileBackhaulTtc> colorList) {
        this.nodeList = nodeList;
        this.lineList = lineList;
        this.colorList = colorList;
    }

    public List<IocMobileBackhaulTtc> getColorList() {
        return colorList;
    }

    public void setColorList(List<IocMobileBackhaulTtc> colorList) {
        this.colorList = colorList;
    }

    public List<Line> getLineList() {
        return lineList;
    }

    public void setLineList(List<Line> lineList) {
        this.lineList = lineList;
    }

    public List<Node> getNodeList() {
        return nodeList;
    }

    public void setNodeList(List<Node> nodeList) {
        this.nodeList = nodeList;
    }
}
