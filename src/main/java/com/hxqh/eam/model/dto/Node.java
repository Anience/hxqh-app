package com.hxqh.eam.model.dto;

/**
 * Created by Ocean lin on 2017/11/9.
 */
public class Node {

    private String name;
    private Integer x;
    private Integer y;

    public Node() {
    }

    public Node(String name, Integer x, Integer y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }
}
