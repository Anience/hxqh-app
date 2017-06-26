package com.hxqh.eam.controller;

/**
 * Created by Ocean Lin on 2017/6/26.
 */

import com.hxqh.eam.model.view.VAno81;
import com.hxqh.eam.model.view.VAno82;
import com.hxqh.eam.service.AnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/ano")
public class AnoController {

    @Autowired
    private AnoService anoService;

    /**
     *  ano81 页面跳转接口
     * @return
     */
    @RequestMapping(value = "/ano81", method = RequestMethod.GET)
    public String ano81() {
        return "ano/ano81";
    }


    /**
     * ano81 数据接口
     * Access 2017-6-26 09:40:21
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/ano81Data", method = RequestMethod.GET)
    public List<VAno81> ano81Data() {
        List<VAno81> ano81Data = anoService.getAno81Data();
        return ano81Data;
    }


    /**
     *  ano82 页面跳转接口
     * @return
     */
    @RequestMapping(value = "/ano82", method = RequestMethod.GET)
    public String ano82() {
        return "ano/ano82";
    }

    /**
     * ano82 数据接口
     * Access 2017-6-26 09:40:29
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/ano82Data", method = RequestMethod.GET)
    public List<VAno82> ano82Data() {
        List<VAno82> ano82Data = anoService.getAno82Data();
        return ano82Data;
    }

}
