package com.hxqh.eam.model.dto.action;

import java.util.List;

/**
 * Created by Ocean lin on 2017/12/22.
 */
public class ArsDto {

    private List<String> w1Aser;
    private List<String> w2Aser;

    private List<Long> w1Attempt;
    private List<Long> w1Answer;

    private List<Long> w2Attempt;
    private List<Long> w2Answer;

    private List<String> weekday;

    public ArsDto() {
    }

    public ArsDto(List<String> w1Aser, List<String> w2Aser, List<Long> w1Attempt, List<Long> w1Answer, List<Long> w2Attempt, List<Long> w2Answer, List<String> weekday) {
        this.w1Aser = w1Aser;
        this.w2Aser = w2Aser;
        this.w1Attempt = w1Attempt;
        this.w1Answer = w1Answer;
        this.w2Attempt = w2Attempt;
        this.w2Answer = w2Answer;
        this.weekday = weekday;
    }

    public List<String> getW1Aser() {
        return w1Aser;
    }

    public void setW1Aser(List<String> w1Aser) {
        this.w1Aser = w1Aser;
    }

    public List<String> getW2Aser() {
        return w2Aser;
    }

    public void setW2Aser(List<String> w2Aser) {
        this.w2Aser = w2Aser;
    }

    public List<Long> getW1Attempt() {
        return w1Attempt;
    }

    public void setW1Attempt(List<Long> w1Attempt) {
        this.w1Attempt = w1Attempt;
    }

    public List<Long> getW1Answer() {
        return w1Answer;
    }

    public void setW1Answer(List<Long> w1Answer) {
        this.w1Answer = w1Answer;
    }

    public List<Long> getW2Attempt() {
        return w2Attempt;
    }

    public void setW2Attempt(List<Long> w2Attempt) {
        this.w2Attempt = w2Attempt;
    }

    public List<Long> getW2Answer() {
        return w2Answer;
    }

    public void setW2Answer(List<Long> w2Answer) {
        this.w2Answer = w2Answer;
    }

    public List<String> getWeekday() {
        return weekday;
    }

    public void setWeekday(List<String> weekday) {
        this.weekday = weekday;
    }
}
