package com.hxqh.eam.service;

import com.hxqh.eam.model.view.VDig13;
import com.hxqh.eam.model.view.VDig14;
import com.hxqh.eam.model.view.VDig17;
import com.hxqh.eam.model.view.VDig18;

import java.util.List;

/**
 * Created by lh on 2017/4/14.
 */
public interface DigitalService {


    public abstract List<VDig13> digital13Data();

    public abstract List<VDig14> vDig14Data();

    public abstract List<VDig17> vDig17Data();

    public abstract List<VDig18> vDig18Data();

    public abstract List<VDig18> vDig13141718Data();


}
