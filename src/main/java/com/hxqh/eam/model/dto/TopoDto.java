package com.hxqh.eam.model.dto;

import java.util.List;

/**
 * Created by Ocean lin on 2017/11/9.
 */
public class TopoDto {
    private List<Node> nodeList;
    private List<Line> lineList;

    public TopoDto() {
    }

    public TopoDto(List<Node> nodeList, List<Line> lineList) {
        this.nodeList = nodeList;
        this.lineList = lineList;
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
