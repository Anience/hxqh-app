package com.hxqh.eam.controller;

/**
 * Created by Ocean Lin on 2017/6/26.
 */

import com.hxqh.eam.model.dto.EntDto;
import com.hxqh.eam.model.dto.EnterpriseDto;
import com.hxqh.eam.service.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/enterprise")
@SessionAttributes(value = "sessionInfo")
public class EnterpriseController {


    @Autowired
    private EnterpriseService enterpriseService;

    /**
     * enterprise  government business Top的所有页面跳转
     * 根据show的值控制跳转页面，type回传
     *
     * @return
     */
    @RequestMapping(value = "/top", method = RequestMethod.GET)
    public ModelAndView top1(@RequestParam("show") String show,
                             @RequestParam("type") String type) {
        Map<String, Object> result = new HashMap<>();
        result.put("page", type);
        result.put("show", show);
        Integer integer = Integer.valueOf(show);
        if (!type.equals("DWS")) {
            if (integer == 1) {
                return new ModelAndView("enterprise/top1", result);
            } else{
                return new ModelAndView("enterprise/top2", result);
            }
        } else {
            return new ModelAndView("enterprise/top1", result);
        }
    }


    /**
     * enterprise  government business Top1Data Top2&3 Top4~7数据接口
     *
     *  1    2    3    4   5 (1个用户轮询5次) 情况A
     *  67    89  1011  1213 (2个用户轮询4次) 情况B
     *  1415 1617 1819  2021 (2个用户轮询4次) 情况C
     *
     *
     * @param show 情况A传入(1,2,3,4,5);  情况B传入(6,8,10,12);  情况C(14,16,18,20)
     * @param type DBS DES DGS
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/top1Data", method = RequestMethod.GET)
    public EnterpriseDto top1Data(@RequestParam("show") Integer show,
                                  @RequestParam("type") String type) {
        EnterpriseDto enterpriseTDto = enterpriseService.getTopData(show, type);
        return enterpriseTDto;
    }


    /**
     * enterprise  government business 页面跳转
     * 根据show的值控制跳转页面,show 回传
     *
     * @return
     */
    @RequestMapping(value = "/ebg", method = RequestMethod.GET)
    public ModelAndView top1(@RequestParam("type") String type) {
        Map<String, Object> result = new HashMap<>();
        result.put("type", type);
        return new ModelAndView("enterprise/entBussiness", result);
    }


    /**
     * enterprise  government business Top1Data 数据接口
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/entData", method = RequestMethod.GET)
    public EntDto entData(@RequestParam("type") String type) {
        EntDto entDto = enterpriseService.getEntData(type);
        return entDto;
    }
    /**
     * urls 页面跳转接口
     *
     * @return
     */
    @RequestMapping(value = "/urls", method = RequestMethod.GET)
    public String wifiInd() {
        return "enterprise/url";
    }

}
