package com.hxqh.eam.controller;

/**
 * Created by Ocean Lin on 2017/6/26.
 */

import com.hxqh.eam.model.base.Status;
import com.hxqh.eam.model.dto.*;
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
     * digital13 页面跳转接口
     *
     * @return
     */
    @RequestMapping(value = "/digital13", method = RequestMethod.GET)
    public String digital13() {
        return "digital/digital";
    }

    /**
     * digital13Data 数据接口
     * Access 2017-6-26 11:05:05
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/vDigital13Data", method = RequestMethod.GET)
    public Dig13Dto digital13Data() {
        List<VDig13> dig13List = digitalService.digital13Data();
        Dig13Dto dig13Dto = new Dig13Dto(dig13List, Status.IOC13);
        return dig13Dto;
    }


    /**
     * digital14 页面跳转接口
     *
     * @return
     */
    @RequestMapping(value = "/digital14", method = RequestMethod.GET)
    public String digital14() {
        return "digital/digital14";
    }


    /**
     * vDig14Data 数据接口
     * Access 2017-6-26 11:05:12
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/vDig14Data", method = RequestMethod.GET)
    public Dig14Dto vDig14Data() {
        List<VDig14> dig13List = digitalService.vDig14Data();
        Dig14Dto dig14Dto = new Dig14Dto(dig13List, Status.IOC14);
        return dig14Dto;
    }

    /**
     * digital17 页面跳转接口
     *
     * @return
     */
    @RequestMapping(value = "/digital17", method = RequestMethod.GET)
    public String digital17() {
        return "digital/digital17";
    }

    /**
     * vDig17Data 数据接口
     * Access 2017-6-26 11:05:50
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/vDig17Data", method = RequestMethod.GET)
    public Dig17Dto vDig17Data() {
        List<VDig17> dig17List = digitalService.vDig17Data();
        Dig17Dto dig17Dto = new Dig17Dto(dig17List, Status.IOC17);
        return dig17Dto;
    }

    /**
     * digital18 页面跳转接口
     *
     * @return
     */
    @RequestMapping(value = "/digital18", method = RequestMethod.GET)
    public String digital18() {
        return "digital/digital18";
    }

    /**
     * vDig18Data 数据接口
     * Access 2017-6-26 11:06:08
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/vDig18Data", method = RequestMethod.GET)
    public Dig18Dto vDig18Data() {
        List<VDig18> dig13List = digitalService.vDig18Data();
        Dig18Dto dig18Dto = new Dig18Dto(dig13List, Status.IOC18);
        return dig18Dto;
    }

    /**
     * digital13141718 页面跳转接口
     *
     * @return
     */
    @RequestMapping(value = "/digital13141718", method = RequestMethod.GET)
    public String digital13141718() {
        return "digital/digital13141718";
    }

    /**
     * vDig13141718Data 数据接口
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/vDig13141718Data", method = RequestMethod.GET)
    public Dig13141718Dto vDig13141718Data() {
        return digitalService.vDig13141718Data();
    }

}

