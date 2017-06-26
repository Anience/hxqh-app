package com.hxqh.eam.controller;

/**
 * Created by Ocean Lin on 2017/6/26.
 */

import com.hxqh.eam.model.view.*;
import com.hxqh.eam.service.DigitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/digital")
public class DigitalController {

    @Autowired
    private DigitalService digitalService;

    /**
     *  digital13 页面跳转接口
     * @return
     */
    @RequestMapping(value = "/digital13", method = RequestMethod.GET)
    public String digital13() {
        return "digital/digital13";
    }

    /**
     *  digital13Data 数据接口
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/digital13Data", method = RequestMethod.GET)
    public List<VDig13> digital13Data() {
        List<VDig13> dig13List = digitalService.digital13Data();
        return dig13List;
    }


    /**
     *  digital14 页面跳转接口
     * @return
     */
    @RequestMapping(value = "/digital14", method = RequestMethod.GET)
    public String digital14() {
        return "digital/digital14";
    }


    /**
     *  vDig14Data 数据接口
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/vDig14Data", method = RequestMethod.GET)
    public List<VDig14> vDig14Data() {
        List<VDig14> dig13List = digitalService.vDig14Data();
        return dig13List;
    }

    /**
     *  digital17 页面跳转接口
     * @return
     */
    @RequestMapping(value = "/digital17", method = RequestMethod.GET)
    public String digital17() {
        return "digital/digital17";
    }

    /**
     *  vDig17Data 数据接口
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/vDig17Data", method = RequestMethod.GET)
    public List<VDig17> vDig17Data() {
        List<VDig17> dig13List = digitalService.vDig17Data();
        return dig13List;
    }

    /**
     *  digital18 页面跳转接口
     * @return
     */
    @RequestMapping(value = "/digital18", method = RequestMethod.GET)
    public String digital18() {
        return "digital/digital18";
    }

    /**
     *  vDig18Data 数据接口
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/vDig18Data", method = RequestMethod.GET)
    public List<VDig18> vDig18Data() {
        List<VDig18> dig13List = digitalService.vDig18Data();
        return dig13List;
    }

    /**
     *  digital13141718 页面跳转接口
     * @return
     */
    @RequestMapping(value = "/digital13141718", method = RequestMethod.GET)
    public String digital13141718() {
        return "digital/digital13141718";
    }

    /**
     *  vDig13141718Data 数据接口
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/vDig13141718Data", method = RequestMethod.GET)
    public List<VDig18> vDig13141718Data() {
        List<VDig18> dig13List = digitalService.vDig13141718Data();
        return dig13List;
    }

}

