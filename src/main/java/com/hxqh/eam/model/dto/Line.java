package com.hxqh.eam.model.dto;

/**
 * Created by Ocean lin on 2017/11/9.
 */
public class Line {

    private String source;
    private String target;

    public Line(String source, String target) {
        this.source = source;
        this.target = target;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }
}
